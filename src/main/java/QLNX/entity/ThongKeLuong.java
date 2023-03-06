package QLNX.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THONG_KE_LUONG") 
public class ThongKeLuong {
	@Id
	@Column(name="MANV")
    private String maNV;
	@Column(name="HO")
    private String ho;
	@Column(name="TENNV")
    private String ten;
	@Column(name="TONGGIO")
    private double tongGio;
	@Column(name="LOAINHANVIEN")
    private String loaiNV;
	@Column(name="TEN")
    private String tenCV;
	@Column(name="LUONG")
	private BigDecimal luong;
	
	public ThongKeLuong() {
	}



	public ThongKeLuong(String maNV, String ho, String ten, double tongGio, String loaiNV, String tenCV,
			BigDecimal luong) {
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.tongGio = tongGio;
		this.loaiNV = loaiNV;
		this.tenCV = tenCV;
		this.luong = luong;
	}



	public BigDecimal getLuong() {
		return luong;
	}



	public void setLuong(BigDecimal luong) {
		this.luong = luong;
	}



	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
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

	public double getTongGio() {
		return tongGio;
	}

	public void setTongGio(double tongGio) {
		this.tongGio = tongGio;
	}

	public String getLoaiNV() {
		return loaiNV;
	}

	public void setLoaiNV(String loaiNV) {
		this.loaiNV = loaiNV;
	}

	public String getTenCV() {
		return tenCV;
	}

	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}

	
}
