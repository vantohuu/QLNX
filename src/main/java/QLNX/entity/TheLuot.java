package QLNX.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CT_THE_LUOT")
public class TheLuot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CT_THE_LUOT")
	private int idCTTheLuot;
	
	//kết nối bảng khách hàng
	@ManyToOne
	@JoinColumn(name="BSX")
	private Xe xe;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANVAO")
	private Date thoiGianVao;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANRA")
	private Date thoiGianRa;
	//kết nối nhân viên thu giữ và cấp thẻ xe
	@ManyToOne
	@JoinColumn(name="MANV1")
	private NhanVien nhanVien1;
	//kết nối nhân viên thu tiền giữ xe
	@ManyToOne
	@JoinColumn(name="MANV2")
	private NhanVien nhanVien2;
	
	public TheLuot() {
	}

	public TheLuot(int idCTTheLuot, Xe xe, Date thoiGianVao, Date thoiGianRa, NhanVien nhanVien1, NhanVien nhanVien2) {
		this.idCTTheLuot = idCTTheLuot;
		this.xe = xe;
		this.thoiGianVao = thoiGianVao;
		this.thoiGianRa = thoiGianRa;
		this.nhanVien1 = nhanVien1;
		this.nhanVien2 = nhanVien2;
	}

	public int getIdCTTheLuot() {
		return idCTTheLuot;
	}

	public void setIdCTTheLuot(int idCTTheLuot) {
		this.idCTTheLuot = idCTTheLuot;
	}

	public Xe getXe() {
		return xe;
	}

	public void setXe(Xe xe) {
		this.xe = xe;
	}

	public Date getThoiGianVao() {
		return thoiGianVao;
	}

	public void setThoiGianVao(Date thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}

	public Date getThoiGianRa() {
		return thoiGianRa;
	}

	public void setThoiGianRa(Date thoiGianRa) {
		this.thoiGianRa = thoiGianRa;
	}

	public NhanVien getNhanVien1() {
		return nhanVien1;
	}

	public void setNhanVien1(NhanVien nhanVien1) {
		this.nhanVien1 = nhanVien1;
	}

	public NhanVien getNhanVien2() {
		return nhanVien2;
	}

	public void setNhanVien2(NhanVien nhanVien2) {
		this.nhanVien2 = nhanVien2;
	}
}
