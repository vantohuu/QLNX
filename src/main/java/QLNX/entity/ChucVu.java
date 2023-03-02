package QLNX.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHUCVU")
public class ChucVu {
	
	@Id
	@Column(name="MACV")
	private String maCV;
	@Column(name="TEN")
	private String ten;

	
	
	@OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
	private List<NhanVien> nhanVien;
	
	@OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
	private List<Luong> luong;
	
	public ChucVu() {}
	public ChucVu(String maCV, String ten, List<NhanVien> nhanVien) {
		this.maCV = maCV;
		this.ten = ten;
		this.nhanVien = nhanVien;
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public List<NhanVien> getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(List<NhanVien> nhanVien) {
		this.nhanVien = nhanVien;
	}


}
