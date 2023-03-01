package QLNX.entity;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CHINH_SUA_PHI")
public class ChinhSuaPhi {
	@Id
	@GeneratedValue
	@Column(name = "ID_CHINH_SUA_PHI")
	private int idChinhSuaPhi;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANTHAYDOI")
	private Date thoiGianThayDoi;
	//kết nối bảng LOAI_PHI
	@ManyToOne
	@JoinColumn(name = "MAPHI")
	private LoaiPhi phi;
	//Kết nối bảng NHAN_VIEN - ghi nhận nhân viên chỉnh sửa phí
	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien nhanVien;
	
	public ChinhSuaPhi() {
	}

	public ChinhSuaPhi(int idChinhSuaPhi, Date thoiGianThayDoi, LoaiPhi phi, NhanVien nhanVien) {
		this.idChinhSuaPhi = idChinhSuaPhi;
		this.thoiGianThayDoi = thoiGianThayDoi;
		this.phi = phi;
		this.nhanVien = nhanVien;
	}

	public int getIdChinhSuaPhi() {
		return idChinhSuaPhi;
	}

	public void setIdChinhSuaPhi(int idChinhSuaPhi) {
		this.idChinhSuaPhi = idChinhSuaPhi;
	}

	public Date getThoiGianThayDoi() {
		return thoiGianThayDoi;
	}

	public void setThoiGianThayDoi(Date thoiGianThayDoi) {
		this.thoiGianThayDoi = thoiGianThayDoi;
	}

	public LoaiPhi getPhi() {
		return phi;
	}

	public void setPhi(LoaiPhi phi) {
		this.phi = phi;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	
}
