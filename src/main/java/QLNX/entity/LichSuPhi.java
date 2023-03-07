package QLNX.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
}
