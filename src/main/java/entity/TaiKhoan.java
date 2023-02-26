package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Column(name="MACV")
	private String maCv ;
	
	
	public TaiKhoan() {}


	public TaiKhoan(String username, String password, int trangThai, int tongGioLam, String maCv) {
		super();
		this.username = username;
		this.password = password;
		this.trangThai = trangThai;
		this.tongGioLam = tongGioLam;
		this.maCv = maCv;
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


	public String getMaCv() {
		return maCv;
	}


	public void setMaCv(String maCv) {
		this.maCv = maCv;
	}

	
}
