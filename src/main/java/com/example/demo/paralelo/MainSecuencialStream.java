package com.example.demo.paralelo;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainSecuencialStream {

	public static void main(String[] args) {
		
		
		List<Integer> idEstudiante = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			idEstudiante.add(i);
		}
		idEstudiante.forEach(a -> System.out.println("Estudiante " + a));
		// PROCESAR ESTUDAINTES
		long tInicial = System.currentTimeMillis();
		List<String> lFinal = idEstudiante.stream().map(a -> procesarIdEstudiante(a)).collect(Collectors.toList());
		long tFinal = System.currentTimeMillis();
		long tTranscurrido = (tFinal - tInicial) / 1000;
		lFinal.forEach(System.out::println);
		System.out.println("Tiempo Transcurrido: " + tTranscurrido + "sec");

	}

	public static String procesarIdEstudiante(Integer idEstudiante) {
		String idConverted = "E" + idEstudiante.toString();
		System.out.println("Insertando Estudiante " + idConverted + "	Hilo: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idConverted;
	}

}
