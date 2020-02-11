package pruebafinal.models;

public class Calificacion {
	private String rut;
	private String nombre;
	private String materia;
	private String notas;
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public Calificacion(String rut, String nombre, String materia, String notas) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.materia = materia;
		this.notas = notas;
	}
	@Override
	public String toString() {
		return "Calificacion [rut=" + rut + ", nombre=" + nombre + ", materia=" + materia + ", notas=" + notas + "]";
		//return "Calificacion [rut=" + rut + ", nombre=" + nombre + ", materia=" + materia + ", notas=" + notas + "]";
	}
	
}
