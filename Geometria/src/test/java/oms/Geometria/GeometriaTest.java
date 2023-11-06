package oms.Geometria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GeometriaTest {

	Geometria geo;
	
	@BeforeAll
	static void setUpBeforeClass() {
	}

	@AfterAll
	static void tearDownAfterClass() {
	}

	@BeforeEach
	void setUp() {
		geo = new Geometria();
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void testGeometriaInt() {
		Geometria geometria = new Geometria(1);
		int id_esperado = 1;
		int id_obtenido = geometria.getId();
		assertEquals(id_esperado, id_obtenido);
	}

	@Test
	void testGeometria() {
		String nombre_esperado = "Default";
		String nombre_obtenido = geo.getNom();
		assertEquals(nombre_esperado, nombre_obtenido);
	}

	@Test
	void testAreacuadrado() {
		int resultado = geo.areacuadrado(1);
		int esperado = 1;
		assertEquals(esperado, resultado);
	}

	@Test
	void testAreaCirculo() {
		double resultado = geo.areaCirculo(1);
		double esperado = 3.1416;
		double delta = 0.001;
		assertEquals(esperado, resultado, delta);
	}

	@Test
	void testAreatriangulo() {
		int resultado = geo.areatriangulo(1, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
	}

	@Test
	void testArearectangulo() {
		int resultado = geo.arearectangulo(2, 3);
		int esperado = 6;
		assertEquals(esperado, resultado);
	}

	@Test
	void testAreapentagono() {
		int resultado = geo.areapentagono(1, 2);
		int esperado = 1;
		assertEquals(esperado, resultado);
	}

	@Test
	void testArearombo() {
		int resultado = geo.arearombo(3, 2);
		int esperado = 3;
		assertEquals(esperado, resultado);
	}

	@Test
	void testArearomboide() {
		int resultado = geo.arearomboide(1, 2);
		int esperado = 2;
		assertEquals(esperado, resultado);
	}

	@Test
	void testAreatrapecio() {
		int resultado = geo.areatrapecio(3, 1, 2);
		int esperado = 4;
		assertEquals(esperado, resultado);
	}
	
	//Juego de datos para el test de la figura
	private static Stream<Arguments> getFormatFixtureFigura() {
		return Stream.of(Arguments.of("cuadrado", 1), Arguments.of("Circulo", 2), Arguments.of("Triangulo", 3),
				Arguments.of("Rectangulo", 4), Arguments.of("Pentagono", 5), Arguments.of("Rombo", 6),
				Arguments.of("Romboide", 7), Arguments.of("Trapecio", 8), Arguments.of("Default", 9));
	}

	@ParameterizedTest
	@MethodSource("getFormatFixtureFigura")
	void testFigura(String esperado, int id) {
		String resultado = geo.figura(id);
		assertEquals(esperado, resultado);
	}

	@Test
	void testGetId() {
		int id_esperado = 9;
		int id_obtenido = geo.getId();
		assertEquals(id_esperado, id_obtenido);
	}

	@Test
	void testSetId() {
		geo.setId(3);
		int id_esperado = 3;
		int id_obtenido = geo.getId();
		assertEquals(id_esperado, id_obtenido);
	}

	@Test
	void testGetNom() {
		String nombre_esperado = "Default";
		String nombre_obtenido = geo.getNom();
		assertEquals(nombre_esperado, nombre_obtenido);
	}

	@Test
	void testSetNom() {
		geo.setNom("Pentagono");
		String nombre_esperado = "Pentagono";
		String nombre_obtenido = geo.getNom();
		assertEquals(nombre_esperado, nombre_obtenido);
	}

	@Test
	void testGetArea() {
		 geo.setArea(5);
		 double area_esperada = 5;
		 double area_obtenida = geo.getArea();
		 assertEquals(area_esperada, area_obtenida);
	}

	@Test
	void testSetArea() {
		 geo.setArea(5);
		 double area_esperada = 5;
		 double area_obtenida = geo.getArea();
		 assertEquals(area_esperada, area_obtenida);
	}

	@Test
	void testToString() {
		geo.setArea(0);
		String toString_esperado = "Geometria [id=9, nom=Default, area=0.0]";
		String toString_obtenido = geo.toString();
		assertEquals(toString_esperado, toString_obtenido);
	}

}
