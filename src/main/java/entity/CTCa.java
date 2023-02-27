package entity;



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
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private TaiKhoan username;
	@ManyToOne
	@JoinColumn(name="MACA")
	private Ca maCa;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date ngay;
	
	public CTCa() {
	}

	public CTCa(int idCTCa, TaiKhoan username, Ca maCa, Date ngay) {
		this.idCTCa = idCTCa;
		this.username = username;
		this.maCa = maCa;
		this.ngay = ngay;
	}



	public int getIdCTCa() {
		return idCTCa;
	}

	public void setIdCTCa(int idCTCa) {
		this.idCTCa = idCTCa;
	}

	

	public TaiKhoan getUsername() {
		return username;
	}



	public void setUsername(TaiKhoan username) {
		this.username = username;
	}



	public Ca getMaCa() {
		return maCa;
	}



	public void setMaCa(Ca maCa) {
		this.maCa = maCa;
	}



	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	
	
}
