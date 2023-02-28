package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repo.ICiudadanoRepo;
import com.example.demo.repo.IEstudianteRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;

	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public List<Ciudadano> consultarTodos() {
		// TODO Auto-generated method stub
		return this.ciudadanoRepo.buscarTodos();
	}

	@Override
	public Estudiante convertir(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		Estudiante estudiante = new Estudiante();
		estudiante.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
		LocalDateTime fechaNacimiento = ciudadano.getFechaNacimiento();
		// Fecha actual
		LocalDateTime fechaActual = LocalDateTime.now();
		// Calcular la edad
		int edad = Period.between(LocalDate.from(fechaNacimiento), LocalDate.from(fechaActual)).getYears();
		estudiante.setEdad(edad);
		return estudiante;
	}

	@Override
	public void procesarEstudiantesParalelo() {
		// TODO Auto-generated method stub
		long tInicial = System.currentTimeMillis();
		List<Ciudadano> ciudadanos = this.ciudadanoRepo.buscarTodos();
		List<Estudiante> estudiantes = ciudadanos.parallelStream().map(a-> this.convertir(a)).collect(Collectors.toList());
		estudiantes.parallelStream().forEach(a-> this.estudianteRepo.insertar(a));
		long tFinal = System.currentTimeMillis();
		long tTranscurrido = (tFinal - tInicial) / 1000;
		System.out.println("Insersion Exitosa");
		System.out.println("Tiempo Transcurrido: " + tTranscurrido + "sec");
	}

}
