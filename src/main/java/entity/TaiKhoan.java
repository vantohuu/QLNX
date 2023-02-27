package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoan {
	
	@Id
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="TRANGTHAI")
	private int trangThai;
	@Column(name="TONGGIOLAM")
	private int tongGioLam;
	@ManyToOne
	@JoinColumn(name="MACV")
	private ChucVuEntity maCV ;
	@OneToMany(mappedBy="username", fetch = FetchType.EAGER)
	private Collection<CTCa> ctCas; 
	
	public TaiKhoan() {}


	
	public TaiKhoan(String username, String password, int trangThai, int tongGioLam, ChucVuEntity maCV) {
		super();
		this.username = username;
		this.password = password;
		this.trangThai = trangThai;
		this.tongGioLam = tongGioLam;
		this.maCV = maCV;
	}

	
	public Collection<CTCa> getCtCas() {
		return ctCas;
	}



	public void setCtCas(Collection<CTCa> ctCas) {
		this.ctCas = ctCas;
	}



	public ChucVuEntity getMaCV() {
		return maCV;
	}



	public void setMaCV(ChucVuEntity maCV) {
		this.maCV = maCV;
	}



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}


	public int getTongGioLam() {
		return tongGioLam;
	}


	public void setTongGioLam(int tongGioLam) {
		this.tongGioLam = tongGioLam;
	}





	public TaiKhoan(String username, String password, int trangThai, int tongGioLam, ChucVuEntity maCV,
			Collection<CTCa> ctCas) {
		super();
		this.username = username;
		this.password = password;
		this.trangThai = trangThai;
		this.tongGioLam = tongGioLam;
		this.maCV = maCV;
		this.ctCas = ctCas;
	}


}
