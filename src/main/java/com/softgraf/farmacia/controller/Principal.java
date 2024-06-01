package com.softgraf.farmacia.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.softgraf.farmacia.model.dao.ConexaoBD;
import com.softgraf.farmacia.model.dao.Endereco;
import com.softgraf.farmacia.model.dao.Estoque;
import com.softgraf.farmacia.model.dao.Produto;
import com.softgraf.farmacia.model.dao.ProdutoDAO;
import com.softgraf.farmacia.view.Teclado;

//import com.softgraf.farmacia.view.Teclado;
import static com.softgraf.farmacia.view.Teclado.*;

public class Principal {

	public static void main(String[] args) throws SQLException {
//		Produto p1 = new Produto("P001", "Vitamina D", 50.00f);
//		Produto p2 = new Produto("P002", "Vitamina C", 65.90f);
//
//		System.out.println(p1);
//		System.out.println(p2);
//
//		Endereco rua = new Endereco().rua("Rua conrado scheiffer").cidade("Ponta grossa").estado("Paraná")
//				.cep("8040-250");
//		System.out.println(rua);
//
//		Estoque estoque = Estoque.getInstancia();
//		System.out.println(estoque);
//		estoque.addProduto(p1);
//		estoque.addProduto(p2);
//		boolean removeu = estoque.removeProduto("p001");
//		System.out.println("Removeu = " + removeu);
//
//		System.out.println(estoque.getQuantidade());
//		System.out.println(estoque.isVazio());
//
//		List<Produto> lista = estoque.listaProdutos();
//		for (Produto produto : lista) {
//			System.out.println(produto);
//		}
		

		ConexaoBD bd = new ConexaoBD();
		Connection conexao = bd.conectar();
		
		ProdutoDAO dao = new ProdutoDAO(conexao);
		dao.criarTabela();
		
//		dao.inserir(p1);
//		System.out.println(p1);
//
//		dao.inserir(p2);
//		System.out.println(p2);

//		dao.remover(3L);
		
//		p1.setId(3);
//		dao.remover(p1);
//		
//		p2.setCodigo("P002");
//		dao.removerPorCodigo("P002");
//		
//		Produto px = new Produto("P001", "insulina", 19.00f);
//		px.setId(1);
//		dao.atualizar(px);
//		
//		List<Produto> lista2 = dao.listar();
//		
//		System.out.println("Tamanho da lista: " + lista2.size());
//		
//	
//		// foreach com lambda -> (javascript =>)
//		lista2.forEach(p -> System.out.println(p));
		
		
		int opcao =0;
		
		do {
		msg("===== Systema de farmácia V 1.0 =====");
		msg("1 = Cadastrar Produto");
		msg("2 = Cadastrar Cliente");
		msg("3 = Cadastrar Pedido");
		msg("9 = Sair do sistema");
		
		opcao = lerInt("Escolha");
		
		//Continua....
		
		}while(opcao != 9);
		
		
		bd.fecharConexao(conexao);
	}

	
}
