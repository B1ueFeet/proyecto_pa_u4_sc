package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.funcional.consumer.IPersonaConsumer;
import com.example.demo.funcional.consumer.PersonaConsummerImpl;
import com.example.demo.funcional.function.IPersonaFunction;
import com.example.demo.funcional.predicate.IPersonaPredicate;
import com.example.demo.funcional.suplier.IPersonaSuplier;
import com.example.demo.funcional.suplier.PersonaSuplier2Impl;
import com.example.demo.funcional.suplier.PersonaSuplierImpl;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// 1. SUPLIER
		LOG.error("SUPLIER");
		// INTERFAZ
		IPersonaSuplier<String> persona = new PersonaSuplierImpl();
		LOG.error("Suplier Clase: " + persona.getNombre());

		IPersonaSuplier<Persona> persona5 = new PersonaSuplier2Impl();
		LOG.info("Suplier Clase: " + persona5.getNombre());

		// LAMBDAS
		IPersonaSuplier<String> persona2 = () -> "Serghy";
		LOG.info("Suplier Lambda: " + persona2.getNombre());

		IPersonaSuplier<Integer> persona3 = () -> Integer.valueOf(5);
		LOG.info("Suplier Lamda: " + persona3.getNombre());

		IPersonaSuplier<Persona> persona4 = () -> {
			Persona per = new Persona();
			per.setApellido("Castillo");
			per.setNombre("Serghy");
			return per;
		};
		LOG.info("Suplier lambda: " + persona4.getNombre());

		// 2. CONSUMER
		LOG.error("CONSUMMER");
		// INTERFAZ
		IPersonaConsumer<String, Integer> consumer = new PersonaConsummerImpl();
		consumer.accept("Procesa este dato INTERFAZ", 3);
		// LAMBDA
		IPersonaConsumer<String, Integer> consumer2 = (a, b) -> LOG.info("Mensaje: " + a + b);
		consumer2.accept("Procesa este dato LAMBDA", 3);

		// 3. PREDICATE
		LOG.error("PREDICATE");
		// LAMBDA
		IPersonaPredicate<String> predicate = a -> a.contains("r");
		LOG.info("Predicate: " + predicate.evaluate("Serghy"));

		IPersonaPredicate<Integer> predicate2 = a -> {
			if (a.intValue() >= 10) {
				return true;
			} else
				return false;
		};
		LOG.info("Predicate: " + predicate2.evaluate(Integer.valueOf(8)));

		// 4. FUNCTION
		LOG.error("FUNCTION");
		// LAMBDA
		IPersonaFunction<String, Integer> function = a -> {
			return "Edison";
		};
		LOG.info("Function: " + function.aplicar(2));

		IPersonaFunction<Ciudadano, Persona> function2 = b -> {
			Ciudadano ciu = new Ciudadano();
			ciu.setNombreCompleto(b.getNombre() + " " + b.getApellido());
			ciu.setCiudad("Quito");
			return ciu;
		};
		Persona persona6 = new Persona();
		persona6.setNombre("Serghy");
		persona6.setApellido("Castillo");
		Ciudadano ciudadano = function2.aplicar(persona6);
		LOG.info("Function: " + ciudadano);
		// 5. UNARY OPERATION
		LOG.error("UNARY OPERATOR");
		// LAMBDA
		IPersonaUnaryOperator<String> unaryOperator = a -> {
			return a.concat("-Sufijo");
		};
		LOG.info("Unary Operator: " + unaryOperator.aplicar("Daniel"));

	}

}
