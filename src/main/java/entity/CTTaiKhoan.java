package entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CT_TAI_KHOAN")
public class CTTaiKhoan {
	
	@Id
	@GeneratedValue
	@Column(name="ID_CT_TAI_KHOAN")
	private String idCTTaiKhoan;
	@Column(name="USERNAME")
	private String username;
	@Column(name="THOIGIANCHINHSUA")
	private Timestamp thoiGianCHinhSua;
	@Column(name="MANV")
	private String maNv;
	@Column(name="LYDO")
	private String lyDo;
	
	public CTTaiKhoan() {};
	
	public CTTaiKhoan(String idCTTaiKhoan, String username, Timestamp thoiGianCHinhSua, String maNv, String lyDo) {
		super();
		this.idCTTaiKhoan = idCTTaiKhoan;
		this.username = username;
		this.thoiGianCHinhSua = thoiGianCHinhSua;
		this.maNv = maNv;
		this.lyDo = lyDo;
	}
	public String getIdCTTaiKhoan() {
		return idCTTaiKhoan;
	}
	public void setIdCTTaiKhoan(String idCTTaiKhoan) {
		this.idCTTaiKhoan = idCTTaiKhoan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getThoiGianCHinhSua() {
		return thoiGianCHinhSua;
	}
	public void setThoiGianCHinhSua(Timestamp thoiGianCHinhSua) {
		this.thoiGianCHinhSua = thoiGianCHinhSua;
	}
	public String getMaNv() {
		return maNv;
	}
	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
	
		
}
