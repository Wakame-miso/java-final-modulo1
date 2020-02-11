package pruebafinal.cl.pruebafinal;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pruebafinal.utils.CalificacionUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalificacionUtilsTest {
//	private final PromedioServicioImp prom = new PromedioServicioImp();
	@Test
	@DisplayName("Crear Promedio")
	public void testCalcularPromedio() {
		CalificacionUtils prom = new CalificacionUtils(); 
		List <Double>valores= new ArrayList <>(); 
		assertEquals (0.0,prom.calcularPromedio(valores));
		
		
		
		
	}
	
}
