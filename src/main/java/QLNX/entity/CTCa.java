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
@Table(name="CT_CA")
public class CTCa {
	@Id
	@GeneratedValue
	@Column(name="ID_CT_CA")
	private int idCTCa;
	//kết nối bàng tài khoản
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan taiKhoan;
	// kết nối bàng ca
	@ManyToOne
	@JoinColumn(name="MACA")
	private Ca ca;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date ngay;
	
	public CTCa() {
	}

	public CTCa(int idCTCa, TaiKhoan taiKhoan, Ca ca, Date ngay) {
		this.idCTCa = idCTCa;
		this.taiKhoan = taiKhoan;
		this.ca = ca;
		this.ngay = ngay;
	}

	public int getIdCTCa() {
		return idCTCa;
	}

	public void setIdCTCa(int idCTCa) {
		this.idCTCa = idCTCa;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
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
