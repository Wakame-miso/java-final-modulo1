package pruebafinal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import pruebafinal.models.Alumno;
import pruebafinal.models.Calificacion;

public class CsvUtils {
	public static List<Calificacion> loadCSV(String ruta) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		return br.lines().map(line -> line.split(","))
				.map(values -> new Calificacion(
						values[0], 
						values[1], 
						values[2], 
						values[3]))
				.collect(Collectors.toList());
	}
}
