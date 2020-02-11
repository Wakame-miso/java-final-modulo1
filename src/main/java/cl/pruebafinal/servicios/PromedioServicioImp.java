package cl.pruebafinal.servicios;

import java.util.List;

public class PromedioServicioImp implements PromedioServicio{

	@Override
	public Double calcularPromedio(List<Double> notas) {
		if(notas!= null) {
			double scale = Math.pow(10, 1);
			return Math.round(notas.stream().mapToDouble(n->n).average().getAsDouble()*scale)/scale;
		}else {
			return 0.0;
		}
	}
	
}
