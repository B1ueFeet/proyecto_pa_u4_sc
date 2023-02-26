package com.example.demo.funcional.function;

@FunctionalInterface
public interface IPersonaFunction <R,T>{

	public R aplicar(T args);
}
