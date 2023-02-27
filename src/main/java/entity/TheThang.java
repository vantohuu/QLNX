package entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.xml.NamespaceHandler;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="THETHANG")
public class TheThang {
	@Id
	@Column(name="ID")
	private String id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAYTAO")
	private Date ngayTao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAYHETHAN")
	private Date ngayHetHan;
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVienEntity maNV;
	@ManyToOne
	@JoinColumn(name="BSX")
	private KhachHang bienSoXe;
	@Column(name="MAPHI")
	private String maPhi;
	
	public TheThang() {
	}

	public TheThang(String id, Date ngayTao, Date ngayHetHan, NhanVienEntity maNV, KhachHang bienSoXe, String maPhi) {
		this.id = id;
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
		this.maNV = maNV;
		this.bienSoXe = bienSoXe;
		this.maPhi = maPhi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public NhanVienEntity getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVienEntity maNV) {
		this.maNV = maNV;
	}

	public KhachHang getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(KhachHang bienSoXe) {
		this.bienSoXe = bienSoXe;
	}

	public String getMaPhi() {
		return maPhi;
	}

	public void setMaPhi(String maPhi) {
		this.maPhi = maPhi;
	}
	
}
