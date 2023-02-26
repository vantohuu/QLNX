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
@Table(name = "NHANVIEN")
public class NhanvienEntity {
	
	@Id
	private String MANV;
	private String HO;
	private String TEN;
	private String GIOITINH;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date NGAYSINH;
	private String DIACHI;
	@Column(name = "[CMND/CCCD]")
	private String CMND_CCCD;
	private String SDT;
	private String EMAIL;
	private BigDecimal LUONG;
	
	public NhanvienEntity() {}
	public NhanvienEntity(String mANV, String hO, String tEN, String gIOITINH, Date nGAYSINH, String dIACHI, String cMND_CCCD,
			String sDT, String eMAIL, BigDecimal lUONG) {
		MANV = mANV;
		HO = hO;
		TEN = tEN;
		GIOITINH = gIOITINH;
		NGAYSINH = nGAYSINH;
		DIACHI = dIACHI;
		CMND_CCCD = cMND_CCCD;
		SDT = sDT;
		EMAIL = eMAIL;
		LUONG = lUONG;
	}
	public String getMANV() {
		return MANV;
	}
	public void setMANV(String mANV) {
		MANV = mANV;
	}
	public String getHO() {
		return HO;
	}
	public void setHO(String hO) {
		HO = hO;
	}
	public String getTEN() {
		return TEN;
	}
	public void setTEN(String tEN) {
		TEN = tEN;
	}
	public String getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public BigDecimal getLUONG() {
		return LUONG;
	}
	public void setLUONG(BigDecimal lUONG) {
		LUONG = lUONG;
	}
	public Date getNGAYSINH() {
		return NGAYSINH;
	}
	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public String getCMND_CCCD() {
		return CMND_CCCD;
	}
	public void setCMND_CCCD(String cMND_CCCD) {
		CMND_CCCD = cMND_CCCD;
	}
}
