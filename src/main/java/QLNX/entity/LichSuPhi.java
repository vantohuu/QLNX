package QLNX.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="LICHSUPHI")
public class LichSuPhi {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LICHSUPHI")
	private int idLichSuPhi;
	
	@ManyToOne
	@JoinColumn(name="BSX")
	private Xe xe;
	
	@ManyToOne
	@JoinColumn(name="ID_PHI")
	private PhiGuiXe phi;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANTAO")
	private Date thoiGianTao = new Date();
	
	public LichSuPhi() {
	}

	public LichSuPhi(Xe xe, PhiGuiXe phi) {
		this.xe = xe;
		this.phi = phi;
	}


	public int getIdLichSuPhi() {
		return idLichSuPhi;
	}


	public void setIdLichSuPhi(int idLichSuPhi) {
		this.idLichSuPhi = idLichSuPhi;
	}


	public Xe getXe() {
		return xe;
	}


	public void setXe(Xe xe) {
		this.xe = xe;
	}


	public PhiGuiXe getPhi() {
		return phi;
	}


	public void setPhi(PhiGuiXe phi) {
		this.phi = phi;
	}
	
	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	
}
