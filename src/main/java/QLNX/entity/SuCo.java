package QLNX.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUCO")
public class SuCo {
	@Id
	@GeneratedValue
	@Column(name = "MASUCO")
	private String maSuCo;
	
	@Column(name = "TEN")
	private String ten;
	
	@Column(name = "MOTA")
	private String moTa;
	//kết nối bảng CT_SU_CO
	@OneToMany(mappedBy = "suCo",fetch = FetchType.LAZY)
	private List<CTSuCo> ctSuCo;
	
	public SuCo() {}
	
	public SuCo(String maSuCo, String ten, String moTa) {
		this.maSuCo = maSuCo;
		this.ten = ten;
		this.moTa = moTa;
	}
	public String getMaSuCo() {
		return maSuCo;
	}
	public void setMaSuCo(String maSuCo) {
		this.maSuCo = maSuCo;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public List<CTSuCo> getCtSuCo() {
		return ctSuCo;
	}
	public void setCtSuCo(List<CTSuCo> ctSuCo) {
		this.ctSuCo = ctSuCo;
	}
	

}
