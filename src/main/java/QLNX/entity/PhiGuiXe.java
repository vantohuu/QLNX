package QLNX.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LOAIPHI")
public class PhiGuiXe {
	@Id
	@GeneratedValue
	@Column(name="ID_PHI")
	private int idPhi;
	
	@Column(name="HINHTHUC")
	private String hinhThuc;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date thoiGianThayDoi;
	
	@ManyToOne
	@JoinColumn(name="LOAIXE")
	private Xe xe;
	@Column(name = "MUCPHI")
	private BigDecimal mucPhi;
	//Kết nối bảng NHAN_VIEN - ghi nhận nhân viên chỉnh sửa phí
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien nhanVien;
	
	
	public PhiGuiXe() {}


	public PhiGuiXe(int idPhi, String hinhThuc, Date thoiGianThayDoi, Xe xe, BigDecimal mucPhi, NhanVien nhanVien) {
		this.idPhi = idPhi;
		this.hinhThuc = hinhThuc;
		this.thoiGianThayDoi = thoiGianThayDoi;
		this.xe = xe;
		this.mucPhi = mucPhi;
		this.nhanVien = nhanVien;
	}


	public int getIdPhi() {
		return idPhi;
	}


	public void setIdPhi(int idPhi) {
		this.idPhi = idPhi;
	}


	public String getHinhThuc() {
		return hinhThuc;
	}


	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}


	public Date getThoiGianThayDoi() {
		return thoiGianThayDoi;
	}


	public void setThoiGianThayDoi(Date thoiGianThayDoi) {
		this.thoiGianThayDoi = thoiGianThayDoi;
	}


	public Xe getXe() {
		return xe;
	}


	public void setXe(Xe xe) {
		this.xe = xe;
	}


	public BigDecimal getMucPhi() {
		return mucPhi;
	}


	public void setMucPhi(BigDecimal mucPhi) {
		this.mucPhi = mucPhi;
	}


	public NhanVien getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
