package QLNX.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAIPHI")
public class LoaiPhi {
	@Id
	@Column(name = "MAPHI")
	private String maPhi;
	
	@Column(name = "TENPHI")
	private String tenPhi;
	
	@Column(name = "LOAIXE")
	private String loaiXe;
	
	@Column(name = "MUCPHI")
	private BigDecimal mucPhi;
	//kết nối bảng loại phí 
	@OneToMany(mappedBy="phi", fetch = FetchType.LAZY)
	private List<CTLoaiPhi> ctLoaiPhi;
	//kết nối bảng chỉnh sửa phí
	@OneToMany(mappedBy="phi", fetch = FetchType.LAZY)
	private List<ChinhSuaPhi> chinhSuaPhi;
	//kết nối bảng thẻ tháng
		@OneToMany(mappedBy="phi", fetch = FetchType.LAZY)
		private List<TheThang> theThang;
	
	public LoaiPhi() {}
	
	
	public LoaiPhi(String maPhi, String tenPhi, String loaiXe, BigDecimal mucPhi) {
		super();
		this.maPhi = maPhi;
		this.tenPhi = tenPhi;
		this.loaiXe = loaiXe;
		this.mucPhi = mucPhi;
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
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public BigDecimal getMucPhi() {
		return mucPhi;
	}
	public void setMucPhi(BigDecimal mucPhi) {
		this.mucPhi = mucPhi;
	}

	public List<CTLoaiPhi> getCtLoaiPhi() {
		return ctLoaiPhi;
	}


	public void setCtLoaiPhi(List<CTLoaiPhi> ctLoaiPhi) {
		this.ctLoaiPhi = ctLoaiPhi;
	}


	public List<ChinhSuaPhi> getChinhSuaPhi() {
		return chinhSuaPhi;
	}


	public void setChinhSuaPhi(List<ChinhSuaPhi> chinhSuaPhi) {
		this.chinhSuaPhi = chinhSuaPhi;
	}


	public List<TheThang> getTheThang() {
		return theThang;
	}


	public void setTheThang(List<TheThang> theThang) {
		this.theThang = theThang;
	}
	
}
