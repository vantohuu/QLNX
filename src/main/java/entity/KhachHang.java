package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="KHACHHANG")
public class KhachHang {
	@Id
	@Column(name="BXS")
	private String bienSoXe;
	@Column(name="HO")
	private String ho;
	@Column(name="TEN")
	private String ten;
	@Column(name="LOAIXE")
	private String loaiXe;
	@Column(name="MACANHAN")
	private String maCaNhan;
	@OneToMany(mappedBy="bienSoXe", fetch = FetchType.EAGER)
	private Collection<CtTheLuot> ctTheLuots; 
	
	public KhachHang() {
	}

	public KhachHang(String bienSoXe, String ho, String ten, String loaiXe, String maCaNhan) {
		this.bienSoXe = bienSoXe;
		this.ho = ho;
		this.ten = ten;
		this.loaiXe = loaiXe;
		this.maCaNhan = maCaNhan;
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
	
	
}
