package clases;

import java.util.ArrayList;

public class Alumno {
	
	protected int id; 
	protected String dni; 
	protected String nombre; 
	protected String email;
	
	//por la relacion que tiene con matriculas
	private ArrayList <Matricula> matriculas; 
	
	
	/**
	 * @return the matriculas
	 */
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	/**
	 * @param matriculas the matriculas to set
	 */
	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	
	
	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	} 
	
	
	

}
