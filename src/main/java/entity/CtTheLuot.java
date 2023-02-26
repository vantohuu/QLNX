package entity;

import java.sql.Date;


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
@Table(name="CT_THE_LUOT")
public class CtTheLuot {
	@Id
	@GeneratedValue
	@Column(name="ID_CT_THE_LUOT")
	private int idCTTheLuot;
	@ManyToOne
	@JoinColumn(name="MATHE")
	private TheLuot maThe;
	@ManyToOne
	@JoinColumn(name="BSX")
	private KhachHang bienSoXe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANVAO")
	private Date thoiGianVao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	@Column(name="THOIGIANRA")
	private Date thoiGianRa;
	
	@Column(name="MANV1")
	private String maNV1;
	
	@Column(name="MANV2")
	private String maNV2;

	public CtTheLuot() {
	}

	public CtTheLuot(int idCTTheLuot, TheLuot maThe, KhachHang bienSoXe, Date thoiGianVao, Date thoiGianRa,
			String maNV1, String maNV2) {
		this.idCTTheLuot = idCTTheLuot;
		this.maThe = maThe;
		this.bienSoXe = bienSoXe;
		this.thoiGianVao = thoiGianVao;
		this.thoiGianRa = thoiGianRa;
		this.maNV1 = maNV1;
		this.maNV2 = maNV2;
	}

	public int getIdCTTheLuot() {
		return idCTTheLuot;
	}

	public void setIdCTTheLuot(int idCTTheLuot) {
		this.idCTTheLuot = idCTTheLuot;
	}

	public TheLuot getMaThe() {
		return maThe;
	}

	public void setMaThe(TheLuot maThe) {
		this.maThe = maThe;
	}

	public KhachHang getBienSoXe() {
		return bienSoXe;
	}

	public void setBienSoXe(KhachHang bienSoXe) {
		this.bienSoXe = bienSoXe;
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

	public String getMaNV1() {
		return maNV1;
	}

	public void setMaNV1(String maNV1) {
		this.maNV1 = maNV1;
	}

	public String getMaNV2() {
		return maNV2;
	}

	public void setMaNV2(String maNV2) {
		this.maNV2 = maNV2;
	}
	
	
}
