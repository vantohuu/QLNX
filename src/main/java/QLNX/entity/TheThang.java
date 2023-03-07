package QLNX.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
<<<<<<< HEAD
=======
import javax.persistence.GenerationType;
>>>>>>> 68a13b4c40180cdadc134e5665a26299bd09b15a
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
<<<<<<< HEAD
	@GeneratedValue
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 68a13b4c40180cdadc134e5665a26299bd09b15a
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

<<<<<<< HEAD
	public TheThang(int id, Date ngayTao, Date ngayHetHan, NhanVien nhanVien, Xe xe) {
		this.id = id;
=======
	public TheThang(Date ngayTao, Date ngayHetHan, NhanVien nhanVien, Xe xe) {
>>>>>>> 68a13b4c40180cdadc134e5665a26299bd09b15a
		this.ngayTao = ngayTao;
		this.ngayHetHan = ngayHetHan;
		this.nhanVien = nhanVien;
		this.xe = xe;
	}

<<<<<<< HEAD


=======
>>>>>>> 68a13b4c40180cdadc134e5665a26299bd09b15a
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

	
}
