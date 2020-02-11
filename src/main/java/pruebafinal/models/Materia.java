package pruebafinal.models;

import java.util.ArrayList;
import java.util.List;

public class Materia {


	public Materia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MateriaEnum nombre;
	public List<Double> notas;
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", notas=" + notas + ", getNombre()=" + getNombre() + ", getNotas()="
				+ getNotas() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public MateriaEnum getNombre() {
		return nombre;
	}

	public void setNombre(MateriaEnum nombre) {
		this.nombre = nombre;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	public boolean agregarNota(Double nota) {
		return this.notas.add(nota);
		
	}

	public Materia(MateriaEnum nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		if(notas!=null)
			this.notas = notas;
		else {
			this.notas = new ArrayList<>();
		}
	}

}
