package QLNX.entity;



import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
@Table(name="THETHANG")
public class TheThang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="NGAYTAO")
	private Date ngayTao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="NGAYHETHAN")
	private Date ngayHetHan;
	//kết nối bảng nhân viên - nhân viên tạo thẻ
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;
	//kết nối bảng Khách hàng
	@ManyToOne
	@JoinColumn(name="BSX")
	private Xe xe;
	public TheThang() {}

	public TheThang(Date ngayTao, Date ngayHetHan, NhanVien nhanVien, Xe xe) {
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
		this.nhanVien = nhanVien;
		this.xe = xe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public int getTrangThai() {
		LocalDateTime now = LocalDateTime.now();  
		Instant instant = now.toInstant(ZoneOffset.UTC);
	    Date date = Date.from(instant);
	    if (this.ngayHetHan.compareTo(date) > 0) return 1;
	    return 0;
	}
}
