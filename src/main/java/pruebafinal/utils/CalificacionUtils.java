package pruebafinal.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pruebafinal.models.Calificacion;

public class CalificacionUtils {

	public static double calcularPromedio(List<Double> valores) {
		double suma = 0;
		for (int i = 0; i < valores.size(); i++) {
			suma += valores.get(i);
		}
		if (valores.size() != 0) {
			System.out.println(suma/valores.size());
			return suma / valores.size();
		} else
			return 0.0;

	}

	public String mostrarCalificaciones(List<Calificacion> lista, String rutAlumno) {

		List<Double> notas = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getRut().equals(rutAlumno)) {
				System.out.println(lista.get(i).toString());
				notas.add(Double.parseDouble(lista.get(i).getNotas()));
			}
		}

		calcularPromedio(notas);
		return null;
	}
}
