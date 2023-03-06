package QLNX.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIGUIXE")
public class PhiGuiXe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PHI")
	private int idPhi;
	
	@Column(name="HINHTHUC")
	private String hinhThuc;
	
	@Column(name="LOAIXE")
	private String loaiXe;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date thoiGianThayDoi;
	
	@OneToMany(mappedBy="phi", fetch = FetchType.LAZY)
	private List<LichSuPhi> lichSuPhi;
	@Column(name = "MUCPHI")
	private BigDecimal mucPhi;
	//Kết nối bảng NHAN_VIEN - ghi nhận nhân viên chỉnh sửa phí
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien nhanVien;
	
	
	public PhiGuiXe() {}


	public PhiGuiXe(String hinhThuc, Date thoiGianThayDoi, String loaiXe,BigDecimal mucPhi, NhanVien nhanVien) {
		this.hinhThuc = hinhThuc;
		this.thoiGianThayDoi = thoiGianThayDoi;
		this.mucPhi = mucPhi;
		this.nhanVien = nhanVien;
		this.loaiXe = loaiXe;
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



	public List<LichSuPhi> getLichSuPhi() {
		return lichSuPhi;
	}


	public void setLichSuPhi(List<LichSuPhi> lichSuPhi) {
		this.lichSuPhi = lichSuPhi;
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
	

	public String getLoaiXe() {
		return loaiXe;
	}


	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

}
