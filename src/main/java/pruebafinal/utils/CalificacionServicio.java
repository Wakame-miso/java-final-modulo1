package pruebafinal.utils;

import java.util.List;

import pruebafinal.models.Alumno;
import pruebafinal.models.AlumnoMateria;
import pruebafinal.models.Materia;

public class CalificacionServicio {

	public static List<AlumnoMateria> agregarCalificacion(List<AlumnoMateria> lista, Alumno alumno, Materia materia){
		
		lista.add(new AlumnoMateria(alumno, materia));
		return lista;
	}
}
