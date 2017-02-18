package com.pnp.barcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN.tbl_master_bahan")
public class MasterBahan {
	
	@Id
	@Column(name="KODE_BAHAN")
	private String kodeBahan;
	
	@Column(name="NAMA_BAHAN")
	private String namaBahan;
	
	@Column(name="JENIS")
	private String jenis;
	
	@Column(name="LEBAR")
	private Integer lebar;
	
	@Column(name="GSM")
	private Integer gsm;
	
	@Column(name="SERI")
	private Integer seri;
	
	@Column(name="PANJANG", nullable=true)
	private Integer panjang;
	
	@Column(name="AKTIF")
	private String aktif;
	
	@Column(name="DESAIN")
	private String desain;
	
	@Column(name="WASTE_PROSES_KK")
	private Integer wasteProsesKK;

	public MasterBahan(String kodeBahan, String namaBahan, String jenis, Integer lebar, Integer gsm, Integer seri, Integer panjang,
			String aktif, String desain, Integer wasteProsesKK) {
		super();
		this.kodeBahan = kodeBahan;
		this.namaBahan = namaBahan;
		this.jenis = jenis;
		this.lebar = lebar;
		this.gsm = gsm;
		this.seri = seri;
		this.panjang = panjang;
		this.aktif = aktif;
		this.desain = desain;
		this.wasteProsesKK = wasteProsesKK;
	}
	
	public MasterBahan(){
		
	}

	public String getKodeBahan() {
		return kodeBahan;
	}

	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}

	public String getNamaBahan() {
		return namaBahan;
	}

	public void setNamaBahan(String namaBahan) {
		this.namaBahan = namaBahan;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public Integer getLebar() {
		return lebar;
	}

	public void setLebar(Integer lebar) {
		this.lebar = lebar;
	}

	public Integer getGsm() {
		return gsm;
	}

	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}

	public Integer getSeri() {
		return seri;
	}

	public void setSeri(Integer seri) {
		this.seri = seri;
	}

	public Integer getPanjang() {
		return panjang;
	}

	public void setPanjang(Integer panjang) {
		try{
			this.panjang = panjang;
		}catch(NumberFormatException e){
			this.panjang = 0;
		}
		
	}

	public String getAktif() {
		return aktif;
	}

	public void setAktif(String aktif) {
		this.aktif = aktif;
	}

	public String getDesain() {
		return desain;
	}

	public void setDesain(String desain) {
		this.desain = desain;
	}

	public Integer getWasteProsesKK() {
		return wasteProsesKK;
	}

	public void setWasteProsesKK(Integer wasteProsesKK) {
		this.wasteProsesKK = wasteProsesKK;
	}
	
	
}
