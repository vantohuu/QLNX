package QLNX.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CT_CHUCVU")
public class CTChucVu {
	@Id
	@GeneratedValue
	@Column(name="ID_CT_CHUCVU")
	private int idLuong;
	
	@ManyToOne
	@JoinColumn(name="MACV")
	private ChucVu chucVu;
	
	@Column(name="LOAINHANVIEN")
	private String loaiNhanVien;
	
	@Column(name="LUONG")
	private BigDecimal luong;
	
	@OneToMany(mappedBy = "CTChucVu", fetch = FetchType.LAZY)
	private List<NhanVien> nhanVien;
	
	public CTChucVu() {}

	public CTChucVu(int idLuong, ChucVu chucVu, String loaiNhanVien, BigDecimal luong) {
		this.idLuong = idLuong;
		this.chucVu = chucVu;
		this.loaiNhanVien = loaiNhanVien;
		this.luong = luong;
	}

	public int getIdLuong() {
		return idLuong;
	}

	public void setIdLuong(int idLuong) {
		this.idLuong = idLuong;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public String getLoaiNhanVien() {
		return loaiNhanVien;
	}

	public void setLoaiNhanVien(String loaiNhanVien) {
		this.loaiNhanVien = loaiNhanVien;
	}

	public BigDecimal getLuong() {
		return luong;
	}

	public void setLuong(BigDecimal luong) {
		this.luong = luong;
	}
}
