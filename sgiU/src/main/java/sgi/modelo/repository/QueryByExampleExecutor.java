package sgi.modelo.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;


public interface QueryByExampleExecutor<T> {
	
	<S extends T> Optional<S> findOne(Example<S> example);
	<S extends T> Iterable<S> findAll(Example<S> example);

}
