package QLNX.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoan {
	
	@Id
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="TRANGTHAI")
	private int trangThai;
	
	@Column(name="TONGGIOLAM")
	private int tongGioLam;
	//kết nối bảng chức vụ
	@ManyToOne
	@JoinColumn(name="MACV")
	private ChucVu cV ;
	//kết nối bảng CT_CA
	@OneToMany(mappedBy="taiKhoan", fetch = FetchType.LAZY)
	private List<CTCa> ctCa;
	//Kết nối bảng nhân viên
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME")
    private NhanVien nhanVien;
	
	@OneToMany(mappedBy="taiKhoan", fetch = FetchType.LAZY)
	private List<CTTaiKhoan> ctTaiKhoan;
	
	public TaiKhoan() {}

	public TaiKhoan(String username, String password, int trangThai, int tongGioLam, ChucVu cV,
			NhanVien nhanVien) {
		this.username = username;
		this.password = password;
		this.trangThai = trangThai;
		this.tongGioLam = tongGioLam;
		this.cV = cV;
		this.nhanVien = nhanVien;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getTongGioLam() {
		return tongGioLam;
	}

	public void setTongGioLam(int tongGioLam) {
		this.tongGioLam = tongGioLam;
	}

	public ChucVu getcV() {
		return cV;
	}

	public void setcV(ChucVu cV) {
		this.cV = cV;
	}

	public List<CTCa> getCtCa() {
		return ctCa;
	}

	public void setCtCa(List<CTCa> ctCa) {
		this.ctCa = ctCa;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<CTTaiKhoan> getCtTaiKhoan() {
		return ctTaiKhoan;
	}

	public void setCtTaiKhoan(List<CTTaiKhoan> ctTaiKhoan) {
		this.ctTaiKhoan = ctTaiKhoan;
	}

}
