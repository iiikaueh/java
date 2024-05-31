package com.softgraf.farmacia.controller;

import java.sql.Connection;
import java.util.List;

import com.softgraf.farmacia.model.dao.ConexaoBD;
import com.softgraf.farmacia.model.dao.Endereco;
import com.softgraf.farmacia.model.dao.Estoque;
import com.softgraf.farmacia.model.dao.Produto;

public class Principal {

	public static void main(String[] args) {
		Produto p1 = new Produto("P001", "Vitamina D", 50.00f);
		Produto p2 = new Produto("P002", "Vitamina C", 65.90f);

		System.out.println(p1);
		System.out.println(p2);

		Endereco rua = new Endereco().rua("Rua conrado scheiffer").cidade("Ponta grossa").estado("Paraná")
				.cep("8040-250");
		System.out.println(rua);

		Estoque estoque = Estoque.getInstancia();
		System.out.println(estoque);
		estoque.addProduto(p1);
		estoque.addProduto(p2);
		boolean removeu = estoque.removeProduto("p001");
		System.out.println("Removeu = " + removeu);

		System.out.println(estoque.getQuantidade());
		System.out.println(estoque.isVazio());

		List<Produto> lista = estoque.listaProdutos();
		for (Produto produto : lista) {
			System.out.println(produto);
		}
		

		ConexaoBD bd = new ConexaoBD();
		Connection conexao = bd.conectar();
		
		bd.fecharConexao(conexao);
	}

	
}
