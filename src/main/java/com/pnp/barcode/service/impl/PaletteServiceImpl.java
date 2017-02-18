package com.pnp.barcode.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pnp.barcode.dao.DataKeluarDao;
import com.pnp.barcode.dao.DetailRimRfidDao;
import com.pnp.barcode.dao.DetailSortirDao;
import com.pnp.barcode.dao.LabelFinishingDao;
import com.pnp.barcode.dao.PaletteDao;
import com.pnp.barcode.dao.impl.DataKeluarDaoImpl;
import com.pnp.barcode.dao.impl.DetailRimRfidDaoImpl;
import com.pnp.barcode.dao.impl.DetailSortirDaoImpl;
import com.pnp.barcode.dao.impl.LabelFinishingDaoImpl;
import com.pnp.barcode.dao.impl.PaletteDaoImpl;
import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.service.PaletteService;

@Service("paletteService")
public class PaletteServiceImpl implements PaletteService{

	private PaletteDao paletteDao = new PaletteDaoImpl();
	private DetailRimRfidDao detailrimRfidDao = new DetailRimRfidDaoImpl();
	private DataKeluarDao dataKeluarDao = new DataKeluarDaoImpl();
	private DetailSortirDao detailSortirDao = new DetailSortirDaoImpl();
	private LabelFinishingDao labelFinishingDao= new LabelFinishingDaoImpl();
	
	public List<ViewPaletteRimRollRfid> getAllPalette(Integer offset, Integer maxResults) {
		// TODO Auto-generated method stub
		return paletteDao.getAllPalette(offset,maxResults);
	}

	public Long rowCount() {
		// TODO Auto-generated method stub
		return paletteDao.rowCount();
	}

	@Override
	public List<DetailRimRfid> getKodeRimByLabelNumber(String startNumber, String endNumber) {
		// TODO Auto-generated method stub
		return detailrimRfidDao.getKodeRimByLabelNumber( startNumber, endNumber);
	}

	@Override
	public List<DetailRimRfid> getKodeRimByLabelNumber(List<String> number) {
		// TODO Auto-generated method stub
		return detailrimRfidDao.getKodeRimByLabelNumber(number);
	}

	@Override
	public List<ViewPaletteRimRollRfid> getAllPalette(List<DetailRimRfid> detail) {
		// TODO Auto-generated method stub
		return paletteDao.getAllPalette(detail);
	}

	@Override
	public File ExportToExcel(List<ViewPaletteRimRollRfid> palettes, List<DataKeluar> dataKeluar, List<DetailSortir> detailSortir, List<DetailRimRfid> detail){
		// TODO Auto-generated method stub
		return paletteDao.ExportToExcel(palettes, dataKeluar, detailSortir, detail);
	}

	@Override
	public DataKeluar findByRollNumber(String rollNumber) {
		// TODO Auto-generated method stub
		return dataKeluarDao .findByRollNumber(rollNumber);
	}

	@Override
	public List<DataKeluar> findByRollNumber(List<ViewPaletteRimRollRfid> palettes) {
		// TODO Auto-generated method stub
		return dataKeluarDao.findByRollNumber(palettes);
	}

	@Override
	public List<DetailSortir> getAllDetailSortir(List<ViewPaletteRimRollRfid> palettes) {
		// TODO Auto-generated method stub
		return detailSortirDao.getAllDetailSortir(palettes);
	}

	@Override
	public List<LabelFinishing> getLabelFinishingByKodeRim(List<DetailRimRfid> details) {
		// TODO Auto-generated method stub
		return labelFinishingDao.getLabelFinishingByKodeRim(details);
	}

	@Override
	public List<DataKeluar> findByPPNumber(List<LabelFinishing> finishing) {
		// TODO Auto-generated method stub
		return dataKeluarDao.findByPPNumber(finishing);
	}

	@Override
	public List<DetailSortir> getAllDetailSortirByDetailRim(List<DetailRimRfid> details) {
		// TODO Auto-generated method stub
		return detailSortirDao.getAllDetailSortirByDetailRim(details);
	}

}
