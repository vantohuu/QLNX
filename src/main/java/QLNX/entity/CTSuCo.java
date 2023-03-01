package QLNX.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CT_SU_CO")
public class CTSuCo {
	@Id
	@GeneratedValue
	@Column(name = "ID_CT_SU_CO")
	private int idCTSuCo;
	
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANXAYRA")
	private Date thoiGianXayRa;
	//kết nối bảng sự cố
	@ManyToOne
	@JoinColumn(name = "MASUCO")
	private SuCo suCo;
	//kết nối bảng khách hàng
	@ManyToOne
	@JoinColumn(name = "BSX")
	private KhachHang khachHang;
	//kết nối bảng nhân viên
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien nhanVien;
	//kết nối bàng CT_SU_CO
	@OneToMany(mappedBy = "ctSuCo", fetch = FetchType.LAZY)
	private List<BienBan> bienBan;
	
	public CTSuCo() {}
	
	public CTSuCo(int idCTSuCo, Date thoiGianXayRa, SuCo suCo, KhachHang khachHang, NhanVien nhanVien) {
		this.idCTSuCo = idCTSuCo;
		this.thoiGianXayRa = thoiGianXayRa;
		this.suCo = suCo;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}
	public int getIdCTSuCo() {
		return idCTSuCo;
	}
	public void setIdCTSuCo(int idCTSuCo) {
		this.idCTSuCo = idCTSuCo;
	}
	public Date getThoiGianXayRa() {
		return thoiGianXayRa;
	}
	public void setThoiGianXayRa(Date thoiGianXayRa) {
		this.thoiGianXayRa = thoiGianXayRa;
	}
	public SuCo getSuCo() {
		return suCo;
	}
	public void setSuCo(SuCo suCo) {
		this.suCo = suCo;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public List<BienBan> getBienBan() {
		return bienBan;
	}
	public void setBienBan(List<BienBan> bienBan) {
		this.bienBan = bienBan;
	}
	
	

}
