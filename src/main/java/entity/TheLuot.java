package entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
	@Column(name="MANV")
	private String maNV;
	
	@OneToMany(mappedBy="idCTTheLuot", fetch = FetchType.EAGER)
	private Collection<CTTheLuot> ctTheLuots; 
	
	public TheLuot() {
	}
	
	public TheLuot(String maThe, Date thoiGianTao, String maNV) {
		this.maThe = maThe;
		this.thoiGianTao = thoiGianTao;
		this.maNV = maNV;
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

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
}
