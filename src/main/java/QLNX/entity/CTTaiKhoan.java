package QLNX.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CT_TAI_KHOAN")
public class CTTaiKhoan {
	
	@Id
	@GeneratedValue
	@Column(name="ID_CT_TAI_KHOAN")
	private String idCTTaiKhoan;
	//kết nối bảng tài khoản
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taiKhoan;
	
	@Column(name="THOIGIANCHINHSUA")
	private Timestamp thoiGianCHinhSua;
	// kết nối bảng nhân viên - ghi nhận nhân viên chỉnh sửa tài khoản
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;
	
	@Column(name="LYDO")
	private String lyDo;
	
	public CTTaiKhoan() {}

	public CTTaiKhoan(String idCTTaiKhoan, TaiKhoan taiKhoan, Timestamp thoiGianCHinhSua, NhanVien nhanVien,
			String lyDo) {
		this.idCTTaiKhoan = idCTTaiKhoan;
		this.taiKhoan = taiKhoan;
		this.thoiGianCHinhSua = thoiGianCHinhSua;
		this.nhanVien = nhanVien;
		this.lyDo = lyDo;
	}

	public String getIdCTTaiKhoan() {
		return idCTTaiKhoan;
	}

	public void setIdCTTaiKhoan(String idCTTaiKhoan) {
		this.idCTTaiKhoan = idCTTaiKhoan;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Timestamp getThoiGianCHinhSua() {
		return thoiGianCHinhSua;
	}

	public void setThoiGianCHinhSua(Timestamp thoiGianCHinhSua) {
		this.thoiGianCHinhSua = thoiGianCHinhSua;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	};
	
}
