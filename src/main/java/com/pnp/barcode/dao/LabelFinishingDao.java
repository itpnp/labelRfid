package com.pnp.barcode.dao;

import com.pnp.barcode.model.LabelFinishing;

import java.util.List;

import com.pnp.barcode.model.DetailRimRfid;;

public interface LabelFinishingDao {

	/**
	 * 
	 * @param kodeRim
	 * @return
	 */
	public LabelFinishing getLabelFinishingByKodeRim(String kodeRim);
	
	/**
	 * 
	 * @param details
	 * @return
	 */
	public List<LabelFinishing> getLabelFinishingByKodeRim(List<DetailRimRfid> details);
}
