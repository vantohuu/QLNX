package entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHUCVU")
public class ChucVuEntity {
	
	@Id
	@Column(name="MACV")
	private String maCV;
	@Column(name="TEN")
	private String ten;
	@Column(name="QUYENHAN")
	private int quyenHan;
	@Column(name="LOAINHANVIEN")
	private String loaiNhanVien;
	@Column(name="LUONGCOBAN")
	private BigDecimal luongCoBan ;
	
	
	public ChucVuEntity() {}


	public ChucVuEntity(String maCv, String ten, int quyenHan, String loaiNhanVien, BigDecimal luongCoBan) {
		this.maCV = maCv;
		this.ten = ten;
		this.quyenHan = quyenHan;
		this.loaiNhanVien = loaiNhanVien;
		this.luongCoBan = luongCoBan;
	}


	public String getMaCv() {
		return maCV;
	}


	public void setMaCv(String maCv) {
		this.maCV = maCv;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public int getQuyenHan() {
		return quyenHan;
	}


	public void setQuyenHan(int quyenHan) {
		this.quyenHan = quyenHan;
	}


	public String getLoaiNhanVien() {
		return loaiNhanVien;
	}


	public void setLoaiNhanVien(String loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}


	public BigDecimal getLuongCoBan() {
		return luongCoBan;
	}


	public void setLuongCoBan(BigDecimal luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
}
