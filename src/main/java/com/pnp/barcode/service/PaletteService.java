package com.pnp.barcode.service;

import java.io.File;
import java.util.List;

import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;

public interface PaletteService {

	/**
	 * 
	 * @param offset
	 * @param maxResults
	 * @return
	 */
	public List<ViewPaletteRimRollRfid> getAllPalette(Integer offset, Integer maxResults);
	
	/**
	 * 
	 * @return
	 */
	public Long rowCount();
	
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
	
	/**
	 * 
	 * @param detail
	 * @return {@link List}
	 */
	public List<ViewPaletteRimRollRfid> getAllPalette(List<DetailRimRfid> detail);
	
	/**
	 * method to export view table into excel file
	 * @param palettets
	 */
	public File ExportToExcel(List<ViewPaletteRimRollRfid> palettes, List<DataKeluar> dataKeluar, List<DetailSortir> detailSortir, List<DetailRimRfid> detail);
	
	/**
	 * 
	 * @param rollNumber
	 * @return
	 */
	public DataKeluar findByRollNumber(String rollNumber);
	
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
	public List<DetailSortir> getAllDetailSortir(List<ViewPaletteRimRollRfid> palettes);	
	
	/**
	 * 
	 * @param kodeRim
	 * @return
	 */
	public List<LabelFinishing> getLabelFinishingByKodeRim(List<DetailRimRfid> details);
	
	/**
	 * 
	 * @param finishing
	 * @return
	 */
	public List<DataKeluar> findByPPNumber(List<LabelFinishing> finishing);
	
	/**
	 * 
	 * @param details
	 * @return
	 */
	public List<DetailSortir> getAllDetailSortirByDetailRim(List<DetailRimRfid> details);

}
