package com.pnp.barcode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pnp.barcode.dao.LabelFinishingDao;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.util.HibernateUtil;

public class LabelFinishingDaoImpl implements LabelFinishingDao {
	private Session session;
	
	@Override
	public LabelFinishing getLabelFinishingByKodeRim(String kodeRim) {
		LabelFinishing label = new LabelFinishing();
		try{
			session  = HibernateUtil.getSessionFactory().openSession();
			label = (LabelFinishing) session.createCriteria(LabelFinishing.class).add(Restrictions.eq("kodeRim", kodeRim)).uniqueResult();
			System.out.println(label.getKodeRim());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return label;
	}
	@Override
	public List<LabelFinishing> getLabelFinishingByKodeRim(List<DetailRimRfid> details) {
		List<LabelFinishing> outputs = new ArrayList<>();
		try{
			for(DetailRimRfid detail : details){
				outputs.add(getLabelFinishingByKodeRim(detail.getKodeRim()));
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return outputs;
	}

}
