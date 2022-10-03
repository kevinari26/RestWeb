package model;

public class Absen {
	private Integer id;
	private String start;
	private String end;

	public Absen (Integer id, String start, String end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	// getter
	public Integer getId() {
		return id;
	}
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}

	// setter
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setSemua(Integer id, String start, String end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}
}
