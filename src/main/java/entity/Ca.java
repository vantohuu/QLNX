package entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CA")
public class Ca {
	@Id
	@Column(name="MACA")
	private String maCa;
	@Column(name="TENCA")
	private String tenCa;
	@Column(name="TGBD")
	private Time tGBD;
	@Column(name="TGKT")
	private Time tGKT;
	
	public Ca() {
	}
	

	public Ca(String maCa, String tenCa, Time tGBD, Time tGKT) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.tGBD = tGBD;
		this.tGKT = tGKT;
	}


	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}

	public Time gettGBD() {
		return tGBD;
	}

	public void settGBD(Time tGBD) {
		this.tGBD = tGBD;
	}

	public Time gettGKT() {
		return tGKT;
	}

	public void settGKT(Time tGKT) {
		this.tGKT = tGKT;
	}
	
	
	
}
