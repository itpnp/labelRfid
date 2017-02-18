package com.pnp.barcode.dao;

import java.util.List;

import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;

public interface DataKeluarDao {

	/**
	 * 
	 * @param rollNumber
	 * @return
	 */
	public DataKeluar findByRollNumber(String rollNumber);
	
	/**
	 * 
	 * @param NoPpCutter
	 * @return
	 */
	public DataKeluar findByPPNumber(String NoPpCutter, String noSop);
	
	/**
	 * 
	 * @param palettes
	 * @return
	 */
	public List<DataKeluar> findByRollNumber(List<ViewPaletteRimRollRfid> palettes);
	
	/**
	 * 
	 * @param palettes
	 * @return
	 */
	public List<DataKeluar> findByPPNumber(List<LabelFinishing> finishing);
}
