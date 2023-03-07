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
@Table(name="THETHANG")
public class TheThang {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAYTAO")
	private Date ngayTao;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
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
	public TheThang() {
	}

	public TheThang(int id, Date ngayTao, Date ngayHetHan, NhanVien nhanVien, Xe xe) {
		this.id = id;
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

	
}
