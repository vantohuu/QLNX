package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NHANVIEN")
public class NhanVienEntity {
	
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
	
	public NhanVienEntity() {}

	public NhanVienEntity(String maNv, String ho, String ten, String gioiTinh, Date ngaySinh, String diaChi,
			String cmndCccd, String sdt, String email) {
		super();
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
}
