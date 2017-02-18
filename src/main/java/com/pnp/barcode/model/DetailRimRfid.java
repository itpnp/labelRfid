package com.pnp.barcode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_detail_rim_rfid")
public class DetailRimRfid {

	@Id
	@Column (name="KODE_RIM")
	private String kodeRim;
	
	@Column(name="NO_LABEL")
	private String noLabel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KODE_BAHAN", nullable = false)
	private MasterBahan masterBahan;
	
	@Column(name="POSITION")
	private String position;
	
	@Column(name="NOMOR_SOP")
	private Integer nomorSop;
	
	@Column(name="NOMOR_ORDER")
	private Integer nomorOrder;
	
	@Column(name="JATUH_TEMPO")
	private Date jatuhTempo;
	
	@Column(name="NOMOR_MUTASI")
	private String nomorMutasi;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="DATE_INPUT")
	private Date dateInput;
	
	@Column(name="LAST_MODIFIED_USER_ID")
	private String lastModifiedUserId;
	
	@Column(name="LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	@Column(name="KIRIMAN_FLAG")
	private String kirimanFlag;
	
	@Column(name="KIRIMAN_DATE")
	private Date kirimanDate;
	
	@Column(name="KELOMPOK_PACKING")
	private String kelompokPacking;
	
	@Column(name="NO_MESIN_HITUNG")
	private String noMesinHitung;

	
	public DetailRimRfid() {
		super();
	}
	
	public DetailRimRfid(String kodeRim, String noLabel, MasterBahan masterBahan, String position, Integer nomorSop,
			Integer nomorOrder, Date jatuhTempo, String nomorMutasi, String userId, Date dateInput,
			String lastModifiedUserId, Date lastModifiedDate, String kirimanFlag, Date kirimanDate,
			String kelompokPacking, String noMesinHitung) {
		super();
		this.kodeRim = kodeRim;
		this.noLabel = noLabel;
		this.masterBahan = masterBahan;
		this.position = position;
		this.nomorSop = nomorSop;
		this.nomorOrder = nomorOrder;
		this.jatuhTempo = jatuhTempo;
		this.nomorMutasi = nomorMutasi;
		this.userId = userId;
		this.dateInput = dateInput;
		this.lastModifiedUserId = lastModifiedUserId;
		this.lastModifiedDate = lastModifiedDate;
		this.kirimanFlag = kirimanFlag;
		this.kirimanDate = kirimanDate;
		this.kelompokPacking = kelompokPacking;
		this.noMesinHitung = noMesinHitung;
	}

	public String getKelompokPacking() {
		return kelompokPacking;
	}

	public void setKelompokPacking(String kelompokPacking) {
		this.kelompokPacking = kelompokPacking;
	}

	public String getNoMesinHitung() {
		return noMesinHitung;
	}

	public void setNoMesinHitung(String noMesinHitung) {
		this.noMesinHitung = noMesinHitung;
	}

	public String getKodeRim() {
		return kodeRim;
	}

	public void setKodeRim(String kodeRim) {
		this.kodeRim = kodeRim;
	}

	public String getNoLabel() {
		return noLabel;
	}

	public void setNoLabel(String noLabel) {
		this.noLabel = noLabel;
	}

	public MasterBahan getMasterBahan() {
		return masterBahan;
	}

	public void setMasterBahan(MasterBahan masterBahan) {
		this.masterBahan = masterBahan;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getNomorSop() {
		return nomorSop;
	}

	public void setNomorSop(Integer nomorSop) {
		this.nomorSop = nomorSop;
	}

	public Integer getNomorOrder() {
		return nomorOrder;
	}

	public void setNomorOrder(Integer nomorOrder) {
		this.nomorOrder = nomorOrder;
	}

	public Date getJatuhTempo() {
		return jatuhTempo;
	}

	public void setJatuhTempo(Date jatuhTempo) {
		this.jatuhTempo = jatuhTempo;
	}

	public String getNomorMutasi() {
		return nomorMutasi;
	}

	public void setNomorMutasi(String nomorMutasi) {
		this.nomorMutasi = nomorMutasi;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDateInput() {
		return dateInput;
	}

	public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}

	public String getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(String lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getKirimanFlag() {
		return kirimanFlag;
	}

	public void setKirimanFlag(String kirimanFlag) {
		this.kirimanFlag = kirimanFlag;
	}

	public Date getKirimanDate() {
		return kirimanDate;
	}

	public void setKirimanDate(Date kirimanDate) {
		this.kirimanDate = kirimanDate;
	}
	
	
	
}
