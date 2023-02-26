package entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CHUCVU")
public class ChucvuEntity {
	
	@Id
	private String MACV;
	private String TEN;
	private int QUYENHAN;
	private String LOAINHANVIEN;
	private BigDecimal LUONGCOBAN;
	
	
	public ChucvuEntity() {}
	public ChucvuEntity(String mACV, String tEN, int qUYENHAN, String lOAINHANVIEN, BigDecimal lUONG) {
		super();
		MACV = mACV;
		TEN = tEN;
		QUYENHAN = qUYENHAN;
		LOAINHANVIEN = lOAINHANVIEN;
		LUONGCOBAN = lUONG;
	}
	public String getMACV() {
		return MACV;
	}
	public void setMACV(String mACV) {
		MACV = mACV;
	}
	public String getTEN() {
		return TEN;
	}
	public void setTEN(String tEN) {
		TEN = tEN;
	}
	public int getQUYENHAN() {
		return QUYENHAN;
	}
	public void setQUYENHAN(int qUYENHAN) {
		QUYENHAN = qUYENHAN;
	}
	public String getLOAINHANVIEN() {
		return LOAINHANVIEN;
	}
	public void setLOAINHANVIEN(String lOAINHANVIEN) {
		LOAINHANVIEN = lOAINHANVIEN;
	}
	public BigDecimal getLUONG() {
		return LUONGCOBAN;
	}
	public void setLUONG(BigDecimal lUONG) {
		LUONGCOBAN = lUONG;
	}
}
