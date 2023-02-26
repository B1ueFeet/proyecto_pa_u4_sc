package com.example.demo.funcional.consumer;

@FunctionalInterface
public interface IPersonaConsumer<T,T2> {
	public void accept(T args1, T2 args2 );
}
