package QLNX.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BIENBAN")
public class BienBan {
	@Id
	@GeneratedValue
	@Column(name = "MABB")
	private String maBienBan;
	
	@Column(name = "TENBB")
	private String tenBienBan;
	//kết nối bảng CT_SU_CO
	@ManyToOne
	@JoinColumn(name = "ID_CT_SU_CO")
	private CTSuCo ctSuCo;
	//kết nối bảng nhân viên - nhân viên lập biên bản
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien nhanVien;
	
	public BienBan () {}

	public BienBan(String maBienBan, String tenBienBan, CTSuCo ctSuCo, NhanVien nhanVien) {
		this.maBienBan = maBienBan;
		this.tenBienBan = tenBienBan;
		this.ctSuCo = ctSuCo;
		this.nhanVien = nhanVien;
	}

	public String getMaBienBan() {
		return maBienBan;
	}

	public void setMaBienBan(String maBienBan) {
		this.maBienBan = maBienBan;
	}

	public String getTenBienBan() {
		return tenBienBan;
	}

	public void setTenBienBan(String tenBienBan) {
		this.tenBienBan = tenBienBan;
	}

	public CTSuCo getCtSuCo() {
		return ctSuCo;
	}

	public void setCtSuCo(CTSuCo ctSuCo) {
		this.ctSuCo = ctSuCo;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
