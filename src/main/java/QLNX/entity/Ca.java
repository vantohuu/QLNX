package QLNX.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CA")
public class Ca {
	@Id
	@Column(name="MACA")
	private String maCa;
	
	@Column(name="TENCA")
	private String tenCa;
	
	@Column(name="THOIGIANBATDAU")
	private Time thoiGianBatDau;
	
	@Column(name="THOIGIANKETTHUC")
	private Time thoiGianKetThuc;
	
	@OneToMany(mappedBy="ca", fetch = FetchType.LAZY)
	private List<LichLamViec> lich; 
	
	public Ca() {
	}

	public Ca(String maCa, String tenCa, Time thoiGianBatDau, Time thoiGianKetThuc) {
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
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

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public List<LichLamViec> getLich() {
		return lich;
	}

	public void setLich(List<LichLamViec> lich) {
		this.lich = lich;
	}
	
}
