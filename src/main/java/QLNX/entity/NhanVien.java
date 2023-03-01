package QLNX.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
	
	@Id
	@Column(name = "MANV")
	private String maNv;
	
	@Column(name = "HO")
	private String ho;
	
	@Column(name = "TEN")
	private String ten;
	
	@Column(name = "GIOITINH")
	private String gioiTinh;
	
	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaySinh;
	
	@Column(name = "DIACHI")
	private String diaChi;
	
	@Column(name = "[CMND/CCCD]")
	private String cmndCccd;
	
	@Column(name = "SDT")
	private String sdt;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToOne(mappedBy = "nhanVien", fetch = FetchType.LAZY)
    private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "nhanVien1", fetch = FetchType.LAZY)
	private List<CTTheLuot> ctTheLuot1;
	
	@OneToMany(mappedBy = "nhanVien2", fetch = FetchType.LAZY)
	private List<CTTheLuot> ctTheLuot2;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<TheThang> theThang;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<ChinhSuaPhi> chinhSuaPhi;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<TheLuot> theLuot;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<CTSuCo> ctSuCo;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<BienBan> bienBan;
	
	@OneToMany(mappedBy = "nhanVien", fetch = FetchType.LAZY)
	private List<CTTaiKhoan> ctTaiKhoan;
	
	public NhanVien() {}

	public NhanVien(String maNv, String ho, String ten, String gioiTinh, Date ngaySinh, String diaChi,
			String cmndCccd, String sdt, String email) {
		this.maNv = maNv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.cmndCccd = cmndCccd;
		this.sdt = sdt;
		this.email = email;
	}
	

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getCmndCccd() {
		return cmndCccd;
	}

	public void setCmndCccd(String cmndCccd) {
		this.cmndCccd = cmndCccd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CTTheLuot> getCtTheLuot1() {
		return ctTheLuot1;
	}

	public void setCtTheLuot1(List<CTTheLuot> ctTheLuot1) {
		this.ctTheLuot1 = ctTheLuot1;
	}

	public List<CTTheLuot> getCtTheLuot2() {
		return ctTheLuot2;
	}

	public void setCtTheLuot2(List<CTTheLuot> ctTheLuot2) {
		this.ctTheLuot2 = ctTheLuot2;
	}

	public List<TheThang> getTheThang() {
		return theThang;
	}

	public void setTheThang(List<TheThang> theThang) {
		this.theThang = theThang;
	}

	public List<ChinhSuaPhi> getChinhSuaPhi() {
		return chinhSuaPhi;
	}

	public void setChinhSuaPhi(List<ChinhSuaPhi> chinhSuaPhi) {
		this.chinhSuaPhi = chinhSuaPhi;
	}

	public List<TheLuot> getTheLuot() {
		return theLuot;
	}

	public void setTheLuot(List<TheLuot> theLuot) {
		this.theLuot = theLuot;
	}

	public List<CTSuCo> getCtSuCo() {
		return ctSuCo;
	}

	public void setCtSuCo(List<CTSuCo> ctSuCo) {
		this.ctSuCo = ctSuCo;
	}

	public List<BienBan> getBienBan() {
		return bienBan;
	}

	public void setBienBan(List<BienBan> bienBan) {
		this.bienBan = bienBan;
	}
}
