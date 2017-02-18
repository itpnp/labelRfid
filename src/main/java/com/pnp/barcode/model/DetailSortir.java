package com.pnp.barcode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_detail_sortir")
public class DetailSortir {
	
	@Id
	@Column(name="KODE_SORTIR")
	private String kodeSortir;
	
	@Column(name="NO_SPP")
	private String noSpp;
	
	@Column(name="KODE_PENGAWAS")
	private String kodePengawas;
	
	@Column(name="TGL_PROSES_SORTIR")
	private Date tanggalProsesSortir;

	public DetailSortir() {
		super();
	}

	public DetailSortir(String kodeSortir, String noSpp, String kodePengawas, Date tanggalProsesSortir) {
		super();
		this.kodeSortir = kodeSortir;
		this.noSpp = noSpp;
		this.kodePengawas = kodePengawas;
		this.tanggalProsesSortir = tanggalProsesSortir;
	}

	public String getKodeSortir() {
		return kodeSortir;
	}

	public void setKodeSortir(String kodeSortir) {
		this.kodeSortir = kodeSortir;
	}

	public String getNoSpp() {
		return noSpp;
	}

	public void setNoSpp(String noSpp) {
		this.noSpp = noSpp;
	}

	public String getKodePengawas() {
		return kodePengawas;
	}

	public void setKodePengawas(String kodePengawas) {
		this.kodePengawas = kodePengawas;
	}

	public Date getTanggalProsesSortir() {
		return tanggalProsesSortir;
	}

	public void setTanggalProsesSortir(Date tanggalProsesSortir) {
		this.tanggalProsesSortir = tanggalProsesSortir;
	}
	
	
}
