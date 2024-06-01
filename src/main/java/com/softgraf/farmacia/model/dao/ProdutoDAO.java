package com.softgraf.farmacia.model.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class ProdutoDAO implements AbstractGenericDAO<Produto> {

	private Connection conexao;

	public ProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void criarTabela() throws SQLException {
		String sql = "create table if not exists Produto(" +
					"codigo varchar (14)," +	
					"descricao varchar (255)," +
					"preco decimal(10, 2)"+ 
					")";
		
		// try with resources 
		try (Statement stmt = conexao.createStatement()){
			stmt.execute(sql);
			System.out.println("Tabela Produto criada!");		
			
		} catch  (SQLException e) {
			System.out.println("Erro ao criar tabela Produto");
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public boolean inserir(Produto p) {
		String sql = "insert into Produto (codigo, descricao, preco) values (?, ?, ?)";
		boolean retorno = false;
		
		// try with resources 
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setFloat(3, p.getPrecoUnitario());
			stmt.executeUpdate();
			stmt.close();
			System.out.println("Produto inserido: " + p.getDescricao());
			long id = ultimoId();
			p.setId(id);
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir produto!");
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	
	public long ultimoId() throws SQLException {
		String sql = "Select last_insert_rowid() as id from Produto";
		
		Statement stmt = conexao.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		
		if (rs.next()) {
			long id  = rs.getLong("id");
			rs.close();
			stmt.close();
			return id;
		} else {
			throw new SQLException("não foi possível obter last_insert_rowid()");
		}
				
		
	}

	@Override
	public void remover(Produto p) {
		remover(p.getId());
	}

	@Override
	public void remover(long id) {
		String sql = "delete from Produto where rowid =?";
		try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao remover produto!");
			e.printStackTrace();
		}
	}
	
	public void removerPorCodigo(String codigo) {
		String sql = "delete from Produto where codigo =?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, codigo);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao remover produto!");
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Produto p) {
	 String sql = "update Produto set codigo =?, descricao =?, preco =? where rowid =?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setFloat(3, p.getPrecoUnitario());		
			stmt.setLong(4, p.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Erro ao atuaizar produto!");
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> listar() {
		
		String sql = "select rowid, codigo, descricao, preco from Produto";
		List<Produto> lista = new ArrayList<Produto>();
		
		try(Statement stmt = conexao.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				long id = rs.getLong("rowid");
				String codigo = rs.getString("codigo");
				String descricao = rs.getString("descricao");
				float preco = rs.getFloat("preco");
				
				Produto p = new Produto(codigo, descricao, preco);
				p.setId(id);
				
				lista.add(p);
			}
			
		}catch (SQLException e) {
			System.out.println("Erro ao listar produtos ");
			e.printStackTrace();
		}
		
		return lista;
		
	}

}
