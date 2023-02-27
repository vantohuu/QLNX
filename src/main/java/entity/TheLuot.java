package entity;

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
	private NhanVienEntity maNV;
	
	@OneToMany(mappedBy="maThe", fetch = FetchType.EAGER)
	private Collection<CTTheLuot> ctTheLuots; 
	
	public TheLuot() {
	}
	
	public TheLuot(String maThe, Date thoiGianTao, NhanVienEntity maNV) {
		this.maThe = maThe;
		this.thoiGianTao = thoiGianTao;
		this.maNV = maNV;
	}

	public Collection<CTTheLuot> getCtTheLuots() {
		return ctTheLuots;
	}

	public void setCtTheLuots(Collection<CTTheLuot> ctTheLuots) {
		this.ctTheLuots = ctTheLuots;
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

	public NhanVienEntity getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVienEntity maNV) {
		this.maNV = maNV;
	}
	
}
