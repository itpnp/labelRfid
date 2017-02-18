package com.pnp.barcode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pnp.barcode.dao.DataKeluarDao;
import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.util.HibernateUtil;

public class DataKeluarDaoImpl implements DataKeluarDao {
	private Session session;
	@Override
	public DataKeluar findByRollNumber(String rollNumber) {
		DataKeluar dataKeluar = new DataKeluar();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			dataKeluar = (DataKeluar) session.createCriteria(DataKeluar.class).add(Restrictions.eq("noRoll", rollNumber)).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}if(session.isOpen()){
			session.close();
		}
		return dataKeluar;
	}

	@Override
	public List<DataKeluar> findByRollNumber(List<ViewPaletteRimRollRfid> palettes) {
		List<DataKeluar> outputs = new ArrayList<>();
		try{
			for(ViewPaletteRimRollRfid palette : palettes){
				outputs.add(findByRollNumber(palette.getNoRoll()));
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}if(session.isOpen()){
			session.close();
		}
		return outputs;
	}

	@Override
	public DataKeluar findByPPNumber(String NoPpCutter, String noSop) {
		DataKeluar dataKeluar = new DataKeluar();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			dataKeluar = (DataKeluar) session.createCriteria(DataKeluar.class)
					.add(Restrictions.eq("noPpCutter", NoPpCutter))
					.add(Restrictions.eq("noSpp", noSop))
					.setMaxResults(1).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
			session.close();
		}
		}
		return dataKeluar;
	}

	@Override
	public List<DataKeluar> findByPPNumber(List<LabelFinishing> finishing) {
		List<DataKeluar> outputs = new ArrayList<>();
		try{
			for(LabelFinishing label : finishing){
				outputs.add(findByPPNumber(label.getLabelFinishing(), label.getNoSop()));
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return outputs;
	}

}
