package com.softgraf.farmacia.view;

import com.softgraf.farmacia.model.dao.Produto;

public class ProdutoView {

	
	//construtor
	private ProdutoView() {};

	public static Produto cadastrar() {
		System.out.println("---- Cadastro de Produto");

		String codigo = Teclado.lerString("Codigo do Produto");
		String descricao = Teclado.lerString("Descrição do Produto");
		float preco = Teclado.lerFloat("Preço do Produto");

		Produto p = new Produto(codigo, descricao, preco);
		return p;
	}

}
