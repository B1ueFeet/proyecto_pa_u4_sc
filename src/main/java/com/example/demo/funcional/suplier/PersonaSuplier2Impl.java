package com.example.demo.funcional.suplier;

import com.example.demo.funcional.Persona;

public class PersonaSuplier2Impl implements IPersonaSuplier<Persona> {

	@Override
	public Persona getNombre() {
		Persona per = new Persona();
		per.setApellido("CastilloS");
		per.setNombre("SerghyS");
		return per;
	}

}
