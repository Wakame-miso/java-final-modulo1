package pruebafinal.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;
import pruebafinal.models.MateriaEnum;

public class DataUtils {
	public static List<Alumno> fabricaAlumno() {
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		List<Materia> materiasPepe = new ArrayList<>();
		List<Materia> materiasSamuel = new ArrayList<>();
		List<Double> notas = new ArrayList<>();
		Materia mate = new Materia(MateriaEnum.MATEMATICAS,notas);
		Materia leng = new Materia(MateriaEnum.LENGUAJE,notas);
		
		materiasPepe.add(mate);
		materiasPepe.add(leng);
		
		materiasSamuel.add(mate);
		
		listaAlumnos.add(new Alumno("18.546.232-1", "Pepe", "Herrera", "Foo Bar 123", materiasPepe));
		listaAlumnos.add(new Alumno("17.423.112-4", "Samuel", "Herrera", "Foo Bar 123", materiasSamuel));
		
		return listaAlumnos;
	}
}
