package com.pnp.barcode.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.LabelFinishing;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.service.PaletteService;

@Controller
@Scope("session")
@RequestMapping("/")
public class PaletteController {

	@Autowired
	private PaletteService paletteService;
	
	@RequestMapping
	public ModelAndView viewPalette(ModelAndView model, Integer offset, Integer maxResults){
		model = new ModelAndView("palette");
		return model;
	}
	
	@RequestMapping(value="/getData", method=RequestMethod.POST)
	public ModelAndView getData(ModelAndView model, @RequestParam String startNumber, 
			@RequestParam String endNumber, @RequestParam String satuan, @RequestParam String kodePengawas,
			Integer offset, Integer maxResults,
			HttpServletRequest request){
		model = new ModelAndView("viewdata");
		List<DetailRimRfid> details = new ArrayList<>();
		List<ViewPaletteRimRollRfid> listPalette = new ArrayList<>();
		if(!satuan.isEmpty() || !satuan.equals("")){
				int size = satuan.length();
				List<String> noLabel = new ArrayList<>();
				String getNumber="";
				for(int i = 0; i<size; i++){
					if(',' == satuan.charAt(i)){
						if(!getNumber.equals("") || !getNumber.isEmpty()){
							noLabel.add(getNumber);
							getNumber ="";
						}
					}else{
						getNumber = getNumber+""+satuan.charAt(i);
					}
					if(i == size-1){
						if(getNumber != null || !getNumber.isEmpty()){
							noLabel.add(getNumber);
							getNumber ="";
						}
					}
				}
			details = paletteService.getKodeRimByLabelNumber(noLabel);
			listPalette = paletteService.getAllPalette(details);
		}else{
			details = paletteService.getKodeRimByLabelNumber(startNumber, endNumber);
			listPalette = paletteService.getAllPalette(details);
		}
		request.getSession().setAttribute("listPalette", listPalette);
		request.getSession().setAttribute("listDetailRim", details);
		request.getSession().setAttribute("kodePengawas", kodePengawas);
		model.addObject("printLabel", details);
		return model;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/export", method=RequestMethod.POST)
	public void Export(ModelAndView model, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws ServletException{
		List<ViewPaletteRimRollRfid> listPalette = (List<ViewPaletteRimRollRfid>)session.getAttribute("listPalette");
		List<DetailRimRfid> details = (List<DetailRimRfid>)session.getAttribute("listDetailRim");
		List<LabelFinishing> finishing = paletteService.getLabelFinishingByKodeRim(details);
		List<DataKeluar> listDataKeluar= paletteService.findByPPNumber(finishing);
		List<DetailSortir> listDetailSortir= paletteService.getAllDetailSortirByDetailRim(details);
//		System.out.println(request.getRemoteAddr());
		String kodePengawas = (String)session.getAttribute("kodePengawas");
		for(DetailSortir data : listDetailSortir){
			data.setKodePengawas(kodePengawas);
		}
		File file = paletteService.ExportToExcel(listPalette, listDataKeluar, listDetailSortir, details);
		try{
			FileInputStream is = new FileInputStream(file);
			String headerValue = String.format("attachment; filename=\"%s\"",file.getName());
			response.setHeader("Content-Disposition", headerValue);
			response.setContentType("application/force-download");
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView homePage(ModelAndView model){
		model = new ModelAndView("palette");
		return model;
	}
}
