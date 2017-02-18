package com.pnp.barcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_detail_lbl_finishing_rfid")
public class LabelFinishing {
	
	@Id
	@Column (name="KODE_RIM")
	private String kodeRim;
	
	@Column(name="LABEL_FINISHING")
	private String labelFinishing;
	
	@Column (name="NOMOR_SOP")
	private String noSop;
	
	public LabelFinishing(String kodeRim, String labelFinishing, String noSop) {
		super();
		this.kodeRim = kodeRim;
		this.labelFinishing = labelFinishing;
		this.noSop = noSop;
	}

	public LabelFinishing() {
		super();
	}

	public String getNoSop() {
		return noSop;
	}

	public void setNoSop(String noSop) {
		this.noSop = noSop;
	}

	public String getKodeRim() {
		return kodeRim;
	}

	public void setKodeRim(String kodeRim) {
		this.kodeRim = kodeRim;
	}

	public String getLabelFinishing() {
		return labelFinishing;
	}

	public void setLabelFinishing(String labelFinishing) {
		this.labelFinishing = labelFinishing;
	}
	
	
	
}
