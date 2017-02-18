package com.pnp.barcode.dao.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.apache.poi.ss.usermodel.Workbook;

import com.pnp.barcode.dao.PaletteDao;
import com.pnp.barcode.model.DataKeluar;
import com.pnp.barcode.model.DetailRimRfid;
import com.pnp.barcode.model.DetailSortir;
import com.pnp.barcode.model.ViewPaletteRimRollRfid;
import com.pnp.barcode.util.HibernateUtil;



@Repository
public class PaletteDaoImpl implements PaletteDao{
	
private Session session;
private Sheet sheet;
	
	@SuppressWarnings("unchecked")
	public List<ViewPaletteRimRollRfid> getAllPalette(Integer offset, Integer maxResults) {
		// TODO Auto-generated method stub
		List<ViewPaletteRimRollRfid> list = new ArrayList<>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			list = session.createCriteria(ViewPaletteRimRollRfid.class)
					.setFirstResult(offset!=null?offset:0)
					.setMaxResults(maxResults!=null?maxResults:1000).list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	public Long rowCount() {
		// TODO Auto-generated method stub
		return (Long)HibernateUtil.getSessionFactory().openSession()
				.createCriteria(ViewPaletteRimRollRfid.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}

	@Override
	public List<ViewPaletteRimRollRfid> getAllPalette(List<DetailRimRfid> detail) {
		// TODO Auto-generated method stub
		List<ViewPaletteRimRollRfid> result = new ArrayList<>();
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			for(DetailRimRfid detailRim : detail){
			  result.add(getAllPalette(detailRim.getKodeRim()));
			}
		}catch(HibernateException e){
	        JOptionPane.showMessageDialog(null,"Retrieve View Palette Data \n"+e, "Error", JOptionPane.ERROR_MESSAGE, null);
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return result;
	}

	@Override
	public ViewPaletteRimRollRfid getAllPalette(String kodeRim) {
		ViewPaletteRimRollRfid list = null;
		try{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			list = (ViewPaletteRimRollRfid)session.createCriteria(ViewPaletteRimRollRfid.class).add(Restrictions.eq("kodeRim", kodeRim)).setMaxResults(1).uniqueResult();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("resource")
	@Override
	public File ExportToExcel(List<ViewPaletteRimRollRfid> palettes, List<DataKeluar> dataKeluar, List<DetailSortir> detailSortir, List<DetailRimRfid> detail){
		File file = null;
		try{
			Workbook workbook = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
			sheet = workbook.createSheet();
			
			/*
			 * Create Header File
			 */
			CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
			Font font = sheet.getWorkbook().createFont();
			font.setBold(true);
			font.setFontHeightInPoints((short)14);
			cellStyle.setFont(font);
			
			Row rowHeader = sheet.createRow(0);
			Cell cellSeri = rowHeader.createCell(0);
			cellSeri.setCellStyle(cellStyle);
			cellSeri.setCellValue("Seri");
			
			
			Cell cellRimCode= rowHeader.createCell(1);
			cellRimCode.setCellStyle(cellStyle);
			cellRimCode.setCellValue("Kode Rim");
			
			Cell cellTanggal = rowHeader.createCell(2);
			cellTanggal.setCellStyle(cellStyle);
			cellTanggal.setCellValue("Tanggal");
			
			Cell cellNomorKode = rowHeader.createCell(3);
			cellNomorKode.setCellStyle(cellStyle);
			cellNomorKode.setCellValue("Nomor Kode");
			for(int i = 0; i<5; i++){
				sheet.autoSizeColumn(i);
			}
			DateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat myFormatCode = new SimpleDateFormat("MMM-dd");
			String nomorKode="";
			String tanggalCode = "";
			String stampingCode = "";
			String cutterCode = "";
			String sortirCode = "";
			String kelompokPacking="";
			String noMesinHitung = "";
			String nomorSeri = "";
			
			for(int i = 0; i<detail.size(); i++){
				sheet.autoSizeColumn(i);
				Row row = sheet.createRow(i+1);
				Cell cell = row.createCell(0);
				if(detail.get(i).getMasterBahan().getSeri()== null){
					cell.setCellValue("MMEA");
					nomorSeri ="4";
				}else{
					cell.setCellValue(detail.get(i).getMasterBahan().getSeri());
					nomorSeri = ""+detail.get(i).getMasterBahan().getSeri();
				}
				
				cell = row.createCell(1);
				cell.setCellValue(detail.get(i).getNoLabel());
				
				String tanggal = myFormat.format(detail.get(i).getDateInput());
				cell = row.createCell(2);
				
				cell.setCellValue(tanggal);
				tanggalCode = myFormatCode.format(detail.get(i).getJatuhTempo());
				stampingCode = dataKeluar.get(i).getNomorMesinStamping()+""+dataKeluar.get(i).getShiftStamping();
				cutterCode = dataKeluar.get(i).getShiftCutter();
				sortirCode = detailSortir.get(i).getKodePengawas();
				kelompokPacking = detail.get(i).getKelompokPacking();
				noMesinHitung = detail.get(i).getNoMesinHitung();
				nomorKode = detail.get(i).getNomorSop()+""+tanggalCode+""+stampingCode+""+cutterCode+""+sortirCode+""+kelompokPacking+""+noMesinHitung;
				cell = row.createCell(3);
				cell.setCellValue(nomorKode);
			}
			 	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH mm ss");
			 	//get current date time with Date()
			 	Date date = new Date();
//				FileOutputStream outputStream = new FileOutputStream("E://Data Label Rfid/"+"S"+nomorSeri+" Data Label "+dateFormat.format(date)+".xls");
				FileOutputStream outputStream = new FileOutputStream("V://Data Label Rfid/"+"S"+nomorSeri+" Data Label "+dateFormat.format(date)+".xls");
				workbook.write(outputStream);
//				file = new File("E://Data Label Rfid/"+"S"+nomorSeri+" Data Label "+dateFormat.format(date)+".xls");
				file = new File("V://Data Label Rfid/"+"S"+nomorSeri+" Data Label "+dateFormat.format(date)+".xls");
		}catch(IOException e){
			e.printStackTrace();
		}
		return file;
	}

}
