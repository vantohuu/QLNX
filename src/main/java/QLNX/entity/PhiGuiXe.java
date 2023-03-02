package QLNX.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAIPHI")
public class PhiGuiXe {
	@Id
	@Column(name = "MAPHI")
	private String maPhi;
	
	@Column(name = "TENPHI")
	private String tenPhi;
	
	@Column(name = "MUCPHI")
	private BigDecimal mucPhi;
	//kết nối bảng chỉnh sửa phí
	@OneToMany(mappedBy="phi", fetch = FetchType.LAZY)
	private List<ChinhSuaPhi> chinhSuaPhi;
	//kết nối bảng xe
	@ManyToOne
	@JoinColumn(name="LOAIXE")
	private Xe xe;
	
	public PhiGuiXe() {}
	
	
	public PhiGuiXe(String maPhi, String tenPhi, BigDecimal mucPhi, List<ChinhSuaPhi> chinhSuaPhi,
			Xe xe) {
		this.maPhi = maPhi;
		this.tenPhi = tenPhi;
		this.mucPhi = mucPhi;
		this.chinhSuaPhi = chinhSuaPhi;
		this.xe = xe;
	}


	public String getMaPhi() {
		return maPhi;
	}
	public void setMaPhi(String maPhi) {
		this.maPhi = maPhi;
	}
	public String getTenPhi() {
		return tenPhi;
	}
	public void setTenPhi(String tenPhi) {
		this.tenPhi = tenPhi;
	}
	
	public BigDecimal getMucPhi() {
		return mucPhi;
	}
	public void setMucPhi(BigDecimal mucPhi) {
		this.mucPhi = mucPhi;
	}


	public List<ChinhSuaPhi> getChinhSuaPhi() {
		return chinhSuaPhi;
	}


	public void setChinhSuaPhi(List<ChinhSuaPhi> chinhSuaPhi) {
		this.chinhSuaPhi = chinhSuaPhi;
	}


	public Xe getXe() {
		return xe;
	}


	public void setXe(Xe xe) {
		this.xe = xe;
	}

}
