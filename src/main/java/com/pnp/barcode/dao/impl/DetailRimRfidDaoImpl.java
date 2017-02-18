package com.pnp.barcode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pnp.barcode.dao.DetailRimRfidDao;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.util.HibernateUtil;

@Repository
public class DetailRimRfidDaoImpl implements DetailRimRfidDao{

	private Session session;
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<DetailRimRfid> getKodeRimByLabelNumber(String startNumber, String endNumber) {
		List<DetailRimRfid> list = new ArrayList<>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
//			list = session.createCriteria(DetailRimRfid.class).add(Restrictions.between("noLabel", startNumber, endNumber)).list();
			Query query = session.createQuery("from DetailRimRfid where noLabel between '"+startNumber+"'AND '"+endNumber+"' order by noLabel asc");
			list = query.list();
			for (DetailRimRfid detail : list) {
			    Hibernate.initialize(detail.getMasterBahan());
			}
		}catch(HibernateException e){
			e.printStackTrace();
	        JOptionPane.showMessageDialog(null,"Retrieve Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("finally")
	public List<DetailRimRfid> getKodeRimByLabelNumber(List<String> number) {
		List<DetailRimRfid> list = new ArrayList<>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			for(String noLabel : number){
				list.add((DetailRimRfid)session.createCriteria(DetailRimRfid.class)
						.add(Restrictions.eq("noLabel", noLabel)).uniqueResult());
				}
			for (DetailRimRfid detail : list) {
			    Hibernate.initialize(detail.getMasterBahan());
			}
		}catch(HibernateException e){
	        JOptionPane.showMessageDialog(null,"Retrieve Area Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
		}finally{
			if(session.isOpen()){
			session.close();
			}
		return list;
		}
	}

}
