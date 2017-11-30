package fr.doctorwho.quetes;

public enum Chapter {

	//Enumeration des chapitres et leur nom
	one(1, "Chapter 1");
	
	private Integer id;
	private String name;
	
	private Chapter(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
