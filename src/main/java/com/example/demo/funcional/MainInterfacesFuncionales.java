package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// 1. SUPLIER
		LOG.error("JAVA SUPLIER");
		Stream<String> lista = Stream.generate(() -> "Serghy").limit(10);
		lista.forEach(a -> LOG.info(a));
		// 2. CONSUMER
		LOG.error("JAVA CONSUMMER");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		listaNumeros.forEach(a -> LOG.info("Valor: " + a));
		// 3. PREDICATE
		LOG.error("JAVA PREDICATE");
		Stream<Integer> filtrada = listaNumeros.stream().filter(a -> a >= 3);
		filtrada.forEach(a -> LOG.info("Valor Filtrado: " + a));
		// 4. FUNCTION
		LOG.error("JAVA FUNCTION");
		Stream<String> listaMappeada = listaNumeros.stream().map(a -> {
			Integer valor = a + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		listaMappeada.forEach(a -> LOG.info(a));
		// 5. UNARY OPERATION
		LOG.error("JAVA UNARY OPERATOR");
	}

}
