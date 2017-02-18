package com.pnp.barcode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pnp.barcode.dao.DetailSortirDao;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.util.HibernateUtil;

public class DetailSortirDaoImpl implements DetailSortirDao{

	private Session session;
	
	@Override
	public DetailSortir getDetailSortir(String sopNumber) {
		// TODO Auto-generated method stub
		DetailSortir detailSortir = new DetailSortir();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			detailSortir = (DetailSortir) session.createCriteria(DetailSortir.class).add(Restrictions.eq("noSpp", sopNumber)).setMaxResults(1).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return detailSortir;
	}

	@Override
	public List<DetailSortir> getAllDetailSortir(List<ViewPaletteRimRollRfid> palettes) {
		// TODO Auto-generated method stub
		List<DetailSortir> list = new ArrayList<>();
		try{
			for(ViewPaletteRimRollRfid palette : palettes){
				list.add(this.getDetailSortir(String.valueOf(palette.getNomorSop())));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DetailSortir> getAllDetailSortirByDetailRim(List<DetailRimRfid> details) {
		// TODO Auto-generated method stub
				List<DetailSortir> list = new ArrayList<>();
				try{
					for(DetailRimRfid detail: details){
						list.add(this.getDetailSortir(String.valueOf(detail.getNomorSop())));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return list;
	}

}
