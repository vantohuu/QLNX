package QLNX.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CT_LOAI_PHI")
public class CTLoaiPhi {
	@Id
	@GeneratedValue
	private int id;
	//kết nối bảng CT_THE_LUOT
	@ManyToOne
	@JoinColumn(name = "ID_CT_THE_LUOT")
	private CTTheLuot ctTheLuot;
	//kết nối bảng LOAIPHI
	@ManyToOne
	@JoinColumn(name = "MAPHI")
	private LoaiPhi phi;
	
	public CTLoaiPhi() {}

	public CTLoaiPhi(int id, CTTheLuot ctTheLuot, LoaiPhi phi) {
		this.id = id;
		this.ctTheLuot = ctTheLuot;
		this.phi = phi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CTTheLuot getCtTheLuot() {
		return ctTheLuot;
	}

	public void setCtTheLuot(CTTheLuot ctTheLuot) {
		this.ctTheLuot = ctTheLuot;
	}

	public LoaiPhi getPhi() {
		return phi;
	}

	public void setPhi(LoaiPhi phi) {
		this.phi = phi;
	}
	
}
