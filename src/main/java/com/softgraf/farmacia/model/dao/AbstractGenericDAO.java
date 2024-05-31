package com.softgraf.farmacia.model.dao;

import java.util.List;

/*
 * DAO é um padrão de projeto
 * DAO (Data acess object) = objeto de Acesso a dados
*/
public interface AbstractGenericDAO<T> {

	boolean inserir (T entidade);
	
	void remover (T entidade);
	 
	void remover (long id);
	
	void atualizar(T entidade);
	
	List<T> listar();
	
}
