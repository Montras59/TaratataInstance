package fr.doctorwho.quetes;

public enum Saison {

	one(1, "Chapter 1"),
	two(2, "Chapter 2"),
	three(3, "Chapter 3"),
	four(4, "Chapter 4"),
	five(5, "Chapter 5"),
	six(6, "Chapter 6"),
	seven(7, "Chapter 7");
	
	private Integer id;
	private String name;
	
	private Saison(Integer id, String name) {
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
