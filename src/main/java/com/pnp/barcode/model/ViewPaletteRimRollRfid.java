package com.pnp.barcode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("session")
@Table(name="WEBHOLO.V_PALETTE_RIM_ROLL_RFID")
public class ViewPaletteRimRollRfid {
	
	@Id
	@Column(name="KODE_PALETTE")
	private Integer kodePalette;
	
	@Column(name="KODE_RIM")
	private String kodeRim;
	
	@Column(name="NO_LABEL")
	private String noLabel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KODE_BAHAN", nullable = false)
	private MasterBahan masterBahan;
	
	@Column(name="NOMOR_SOP")
	private Integer nomorSop;
	
	@Column(name="JATUH_TEMPO")
	private Date jatuhTempo;
	
	@Column(name="LABEL_FINISHING")
	private String LabelFinishing;
	
	@Column(name="NO_ROLL")
	private String noRoll;

	@Column(name="NOMOR_ORDER")
	private String nomorOrder;
	
	

	public ViewPaletteRimRollRfid(Integer kodePalette, String kodeRim, String noLabel, MasterBahan  masterBahan,
			Integer nomorSop, Date jatuhTempo, String labelFinishing, String noRoll, String nomorOrder) {
		super();
		this.kodePalette = kodePalette;
		this.kodeRim = kodeRim;
		this.noLabel = noLabel;
		this.masterBahan = masterBahan;
		this.nomorSop = nomorSop;
		this.jatuhTempo = jatuhTempo;
		LabelFinishing = labelFinishing;
		this.noRoll = noRoll;
		this.nomorOrder = nomorOrder;
	}

	public ViewPaletteRimRollRfid(){
	}
	
	
	public String getNomorOrder() {
		return nomorOrder;
	}

	public void setNomorOrder(String nomorOrder) {
		this.nomorOrder = nomorOrder;
	}

	public Integer getKodePalette() {
		return kodePalette;
	}

	public void setKodePalette(Integer kodePalette) {
		this.kodePalette = kodePalette;
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
		return masterBahan ;
	}

	public void setKodeBahan(MasterBahan  masterBahan) {
		this.masterBahan  = masterBahan ;
	}

	public Integer getNomorSop() {
		return nomorSop;
	}

	public void setNomorSop(Integer nomorSop) {
		this.nomorSop = nomorSop;
	}

	public Date getJatuhTempo() {
		return jatuhTempo;
	}

	public void setJatuhTempo(Date jatuhTempo) {
		this.jatuhTempo = jatuhTempo;
	}

	public String getLabelFinishing() {
		return LabelFinishing;
	}

	public void setLabelFinishing(String labelFinishing) {
		LabelFinishing = labelFinishing;
	}

	public String getNoRoll() {
		return noRoll;
	}

	public void setNoRoll(String noRoll) {
		this.noRoll = noRoll;
	}
	
	
}
