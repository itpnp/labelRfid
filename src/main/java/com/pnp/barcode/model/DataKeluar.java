package com.pnp.barcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_keluar")
public class DataKeluar {

	@Column (name="NO_BON")
	private String noBon;
	
	@Column (name="TGL_BON")
	private String tglBon;
	
	@Column (name="JENIS")
	private String jenis;
	
	@Id
	@Column (name="NO_ROLL")
	private String noRoll;
	
	@Column(name="SHIFT")
	private String shiftCutter;
	
	@Column(name="SHIFT_STAMP")
	private String shiftStamping;
	
	@Column(name="NOMESIN_STAMP")
	private Integer nomorMesinStamping;
	
	@Column (name = "NOMOR_PP_CUTTER")
	private String noPpCutter;
	
	@Column (name = "NO_SPP")
	private String noSpp;

	public DataKeluar() {
		super();
	}

	public DataKeluar(String noBon, String tglBon, String jenis, String noRoll, String shiftCutter,
			String shiftStamping, Integer nomorMesinStamping, String noPpCutter, String noSpp) {
		super();
		this.noBon = noBon;
		this.tglBon = tglBon;
		this.jenis = jenis;
		this.noRoll = noRoll;
		this.shiftCutter = shiftCutter;
		this.shiftStamping = shiftStamping;
		this.nomorMesinStamping = nomorMesinStamping;
		this.noPpCutter = noPpCutter;
		this.noSpp = noSpp;
	}



	public String getNoSpp() {
		return noSpp;
	}

	public void setNoSpp(String noSpp) {
		this.noSpp = noSpp;
	}

	public String getNoPpCutter() {
		return noPpCutter;
	}

	public void setNoPpCutter(String noPpCutter) {
		this.noPpCutter = noPpCutter;
	}

	public String getNoBon() {
		return noBon;
	}

	public void setNoBon(String noBon) {
		this.noBon = noBon;
	}

	public String getTglBon() {
		return tglBon;
	}

	public void setTglBon(String tglBon) {
		this.tglBon = tglBon;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getNoRoll() {
		return noRoll;
	}

	public void setNoRoll(String noRoll) {
		this.noRoll = noRoll;
	}

	public String getShiftCutter() {
		return shiftCutter;
	}

	public void setShiftCutter(String shiftCutter) {
		this.shiftCutter = shiftCutter;
	}

	public String getShiftStamping() {
		return shiftStamping;
	}

	public void setShiftStamping(String shiftStamping) {
		this.shiftStamping = shiftStamping;
	}

	public Integer getNomorMesinStamping() {
		return nomorMesinStamping;
	}

	public void setNomorMesinStamping(Integer nomorMesinStamping) {
		this.nomorMesinStamping = nomorMesinStamping;
	}
	
	
}
