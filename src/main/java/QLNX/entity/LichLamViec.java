package QLNX.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
   
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="LICHLAMVIEC")
public class LichLamViec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LICHLAMVIEC")
	private int idLichLamViec;
	//kết nối bảng nhân viên
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;
	// kết nối bàng ca
	@ManyToOne
	@JoinColumn(name="MACA")
	private Ca ca;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date ngay;
	
	public LichLamViec() {}

	public LichLamViec(NhanVien nhanVien, Ca ca, Date ngay) {
		this.nhanVien = nhanVien;
		this.ca = ca;
		this.ngay = ngay;
	}

	public int getIdLichLamViec() {
		return idLichLamViec;
	}

	public void setIdLichLamViec(int idLichLamViec) {
		this.idLichLamViec = idLichLamViec;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Ca getCa() {
		return ca;
	}

	public void setCa(Ca ca) {
		this.ca = ca;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	
}
