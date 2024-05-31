package com.softgraf.farmacia.model.dao;

import java.util.Objects;

public class Produto {

	private long id;
	private String codigo;
	private String descricao;
	private float precoUnitari;

	public Produto() {

	}

	public Produto(String codigo, String descricao, float precoUnitari) {

		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitari = precoUnitari;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoUnitari() {
		return precoUnitari;
	}

	public void setPrecoUnitari(float precoUnitari) {
		this.precoUnitari = precoUnitari;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo) && id == other.id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", precoUnitari=" + precoUnitari + "]";
	}

	
}
