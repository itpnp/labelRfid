package com.pnp.barcode.dao;

import java.io.File;
import java.util.List;

import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;

public interface PaletteDao {

	/**
	 * method for pagination
	 * @param offset
	 * @param maxResults
	 * @return {@link List}
	 */
	public List<ViewPaletteRimRollRfid> getAllPalette(Integer offset, Integer maxResults);
	
	/**
	 * method for pagination
	 * @return Long
	 */
	public Long rowCount();
	
	/**
	 * method to get data from View table with more than one rim code parameter
	 * @param detail
	 * @return {@link List}
	 */
	public List<ViewPaletteRimRollRfid> getAllPalette(List<DetailRimRfid> detail);
	
	/** 
	 * method to get data from View table with one rim code parameter
	 * @param kodeRim
	 * @return
	 */
	public ViewPaletteRimRollRfid getAllPalette(String kodeRim);
	
	/**
	 * method to export view table into excel file
	 * @param palettets
	 */
	public File ExportToExcel(List<ViewPaletteRimRollRfid> palettes, List<DataKeluar> dataKeluar, List<DetailSortir> detailSortir, List<DetailRimRfid> detail);

}
