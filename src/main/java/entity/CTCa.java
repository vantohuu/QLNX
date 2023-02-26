package entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@Column(name="USERNAME")
	private String username;
	@Column(name="MACA")
	private String maCa;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="NGAY")
	private Date ngay;
	
	public CTCa() {
	}

	public CTCa(int idCTCa, String username, String maCa, Date ngay) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	
	
}
