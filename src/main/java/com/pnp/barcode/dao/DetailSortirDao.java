package com.pnp.barcode.dao;

import java.util.List;

import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;

public interface DetailSortirDao {

	public DetailSortir getDetailSortir(String sopNumber);
	public List<DetailSortir> getAllDetailSortir(List<ViewPaletteRimRollRfid> palettes);	
	public List<DetailSortir> getAllDetailSortirByDetailRim(List<DetailRimRfid> details);
}
