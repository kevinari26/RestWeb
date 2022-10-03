package model;

public class Karyawan {
	private Integer id;
	private String nama;
	private String alamat;

	public Karyawan() {
	}

	public Karyawan(Integer id, String nama, String alamat) {
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
	}

	// getter
	public Integer getId() {
		return id;
	}
	public String getNama() {
		return nama;
	}
	public String getAlamat() {
		return alamat;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public void setSemua(Integer id, String nama, String alamat) {
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
	}
}
