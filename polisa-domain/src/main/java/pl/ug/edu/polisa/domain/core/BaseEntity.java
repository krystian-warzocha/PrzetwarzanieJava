package pl.ug.edu.polisa.domain.core;

public abstract class BaseEntity {
	
	/**
	 * Identyfikator encji.
	 */
	@Column(columnName="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Metoda do tekstowej reprezentacji obiektu.
	 * @return
	 */
	public abstract String displayable();
	
	/**
	 * Metoda zwracajaca nazwe tabeli w bazie danych.
	 * @return
	 */
	public abstract String tableName();
	
} 