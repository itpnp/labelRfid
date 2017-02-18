package com.pnp.barcode.dao;

import java.util.List;

import com.pnp.barcode.model.DetailRimRfid;
public interface DetailRimRfidDao {

	/**
	 * 
	 * @param startNumber
	 * @param endNumber
	 * @return {@link DetailRimRfid}
	 */
	public List<DetailRimRfid> getKodeRimByLabelNumber(String startNumber, String endNumber);
	
	/**
	 * 
	 * @param number
	 * @return {@link DetailRimRfid}
	 */
	public List<DetailRimRfid> getKodeRimByLabelNumber(List<String> number);
}
