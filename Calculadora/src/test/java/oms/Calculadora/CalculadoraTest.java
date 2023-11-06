package oms.Calculadora;

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

class CalculadoraTest {

	Calculadora cal;
	@BeforeAll
	static void setUpBeforeClass() {
	}

	@AfterAll
	static void tearDownAfterClass() {
	}

	@BeforeEach
	void setUp() {
		cal = new Calculadora();
	}

	@AfterEach
	void tearDown() {
		cal = null;
	}

	@Test
	void testCambiarSigno() {
		String esperado = "-5.0";
		String obtenido = cal.cambiarSigno("5");
		assertEquals(esperado, obtenido);
	}

	@Test
	void testEliminarDigito() {
		String esperado = "12";
		String obtenido = cal.eliminarDigito("123");
		assertEquals(esperado, obtenido);
	}

	@Test
	void testLimpiarCalculadora() {
		String esperado = "0";
		String obtenido = cal.limpiarCalculadora();
		assertEquals(esperado, obtenido);
	}

	//Juego de datos para el test de operar
	private static Stream<Arguments> getFormatFixtureOperar() {
		return Stream.of(Arguments.of("+", 1.0, "2", "3.0"), Arguments.of("-", 5.0, "1", "4.0"),
				Arguments.of("*", 4.5, "2", "9.0"), Arguments.of("/", 17.0, "2", "8.5"));
	}
	@ParameterizedTest
	@MethodSource("getFormatFixtureOperar")
	void testOperar(String operacion, Double op1, String op2, String esperado) {
		String resultado = cal.operar(operacion, op1, op2);
		assertEquals(esperado, resultado);
	}

}
