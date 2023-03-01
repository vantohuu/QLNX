package QLNX.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="THELUOT")
public class TheLuot {
	@Id
	@Column(name="MATHE")
	private String maThe;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="THOIGIANTAO")
	private Date thoiGianTao;
	
	@ManyToOne
	@JoinColumn(name="MANV")
	private NhanVien nhanVien;
	
	@OneToMany(mappedBy="theLuot", fetch = FetchType.LAZY)
	private Collection<CTTheLuot> ctTheLuot; 
	
	public TheLuot() {
	}

	public TheLuot(String maThe, Date thoiGianTao, NhanVien nhanVien, Collection<CTTheLuot> ctTheLuot) {
		this.maThe = maThe;
		this.thoiGianTao = thoiGianTao;
		this.nhanVien = nhanVien;
		this.ctTheLuot = ctTheLuot;
	}

	public String getMaThe() {
		return maThe;
	}

	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Collection<CTTheLuot> getCtTheLuot() {
		return ctTheLuot;
	}

	public void setCtTheLuot(Collection<CTTheLuot> ctTheLuot) {
		this.ctTheLuot = ctTheLuot;
	}
	
	
}
