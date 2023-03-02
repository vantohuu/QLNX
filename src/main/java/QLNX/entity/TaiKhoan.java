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

	//Kết nối bảng nhân viên
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME")
    private NhanVien nhanVien;
	
	public TaiKhoan() {}
	

	public TaiKhoan(String username, String password, int trangThai, NhanVien nhanVien) {

		this.username = username;
		this.password = password;
		this.trangThai = trangThai;
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


	public NhanVien getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
