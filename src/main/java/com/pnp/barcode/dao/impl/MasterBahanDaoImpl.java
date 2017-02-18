package com.pnp.barcode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.pnp.barcode.dao.MasterBahanDao;
import com.pnp.barcode.model.MasterBahan;
import com.pnp.barcode.util.HibernateUtil;

@Repository
public class MasterBahanDaoImpl implements MasterBahanDao {

	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<MasterBahan> getAllBahan() {
		// TODO Auto-generated method stub
		List<MasterBahan> masterBahan = new ArrayList<>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from MasterBahan");
			 masterBahan = query.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return masterBahan;
	}

}
