package QLNX.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="XE")
public class Xe {
	@Id
	@Column(name="BSX")
	private String bienSoXe;
	
	@Column(name="HO")
	private String ho;
	
	@Column(name="TEN")
	private String ten;
	
	@Column(name="LOAIXE")
	private String loaiXe;
	
	@Column(name="MACANHAN")
	private String maCaNhan;
	

	@OneToMany(mappedBy="xe", fetch = FetchType.LAZY)
	private List<PhiGuiXe> phi;
	
	@OneToMany(mappedBy="xe", fetch = FetchType.LAZY)
	private List<TheLuot> theLuot;
	
	
	@OneToMany(mappedBy="xe", fetch = FetchType.LAZY)
	private List<TheThang> theThang; 
	
	public Xe() {
	}

	public Xe(String bienSoXe, String ho, String ten, String loaiXe, String maCaNhan) {
		this.bienSoXe = bienSoXe;
		this.ho = ho;
		this.ten = ten;
		this.loaiXe = loaiXe;
		this.maCaNhan = maCaNhan;
	}

	public Xe(String bienSoXe, String loaiXe) {
		this.bienSoXe = bienSoXe;
		this.loaiXe = loaiXe;
	}

	public String getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(String bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getMaCaNhan() {
		return maCaNhan;
	}

	public void setMaCaNhan(String maCaNhan) {
		this.maCaNhan = maCaNhan;
	}

	public List<TheLuot> getTheLuot() {
		return theLuot;
	}

	public void setTheLuot(List<TheLuot> theLuot) {
		this.theLuot = theLuot;
	}

	public List<TheThang> getTheThang() {
		return theThang;
	}

	public void setTheThang(List<TheThang> theThang) {
		this.theThang = theThang;
	}
	
	public List<PhiGuiXe> getPhi() {
		return phi;
	}

	public void setPhi(List<PhiGuiXe> phi) {
		this.phi = phi;
	}
	
}
