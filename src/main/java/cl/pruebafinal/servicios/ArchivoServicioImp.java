package cl.pruebafinal.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pruebafinal.models.MateriaEnum;
import pruebafinal.models.Alumno;
import pruebafinal.models.Materia;

public class ArchivoServicioImp implements ArchivoServicio{
	private List<Alumno> alumnosACargar = new ArrayList<>();
	private PromedioServicioImp promedioServicioImp = new PromedioServicioImp();
	@Override
	public List<Alumno> cargarDatos(String ruta) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta + "/notas.csv"))) {
			String lineas;
			while ((lineas = br.readLine()) != null) {
				String[] alumnoDesdeArchivo = lineas.split(",");

				Alumno alumnoEnMemoria = alumnosACargar.stream()
						.filter(alumno -> alumno.getRut().equals(alumnoDesdeArchivo[0])).findFirst().orElse(null);

				if (alumnoEnMemoria == null) {
					List<Materia> materias = new ArrayList<>();
					Alumno nuevoAlumno = setDatosAlumno(alumnoDesdeArchivo[0], alumnoDesdeArchivo[1]);
					Materia nuevaMateria = setDatosMateria(alumnoDesdeArchivo[2]);
					List<Double> notas = new ArrayList<>();
					notas.add(Double.parseDouble(alumnoDesdeArchivo[3]));
					nuevaMateria.setNotas(notas);
					materias.add(nuevaMateria);
					nuevoAlumno.setMaterias(materias);
					alumnosACargar.add(nuevoAlumno);
				} else {
					Materia materiaParaAgregar = alumnoEnMemoria.getMaterias().stream()
							.filter(materia -> materia.getNombre().name().equals(alumnoDesdeArchivo[2])).findFirst()
							.orElse(null);

					if (materiaParaAgregar == null) {
						materiaParaAgregar = setDatosMateria(alumnoDesdeArchivo[2]);
						alumnoEnMemoria.getMaterias().add(materiaParaAgregar);
						List<Double> notas = new ArrayList<>();
						notas.add(Double.parseDouble(alumnoDesdeArchivo[3]));
						materiaParaAgregar.setNotas(notas);
					} else {
						materiaParaAgregar.getNotas().add(Double.parseDouble(alumnoDesdeArchivo[3]));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alumnosACargar;

	}


	@Override
	public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
//		String str = "Hello";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/promedios.txt"))) {
			for (Map.Entry<String, Alumno> alumno : alumnos.entrySet()) {
				writer.write("Alumno : " + alumno.getKey() + " - " + alumno.getValue().getNombre());
				writer.newLine();
				if (alumno.getValue().getMaterias() != null) {
					for (Materia materia : alumno.getValue().getMaterias()) {
						if (materia.getNotas() != null) {
							writer.write("\tMateria : " + materia.getNombre() + " - Promedio : "
									+ promedioServicioImp.calcularPromedio(materia.getNotas()));
							writer.newLine();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Alumno setDatosAlumno(String rut, String nombre) {
		Alumno nuevoAlumno = new Alumno();
		nuevoAlumno.setRut(rut);
		nuevoAlumno.setNombre(nombre);
		return nuevoAlumno;
	}

	@Override
	public Materia setDatosMateria(String nombre) {
		Materia nuevaMateria = new Materia();
		switch (nombre) {
		case "MATEMATICAS":
			nuevaMateria.setNombre(MateriaEnum.MATEMATICAS);
			break;
		case "LENGUAJE":
			nuevaMateria.setNombre(MateriaEnum.LENGUAJE);
			break;
		case "HISTORIA":
			nuevaMateria.setNombre(MateriaEnum.HISTORIA);
			break;
		case "CIENCIA":
			nuevaMateria.setNombre(MateriaEnum.CIENCIA);
			break;
		}
		return nuevaMateria;
	}

}
