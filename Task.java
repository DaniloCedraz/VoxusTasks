package br.com.voxus.model;

public class Task {

	private String nome;
	private String status;
	private String descricao;
	private int prioridade;
	
	public Task() {
		nome = " ";
		status = " ";
		descricao = " ";
		prioridade = 0;
	}
	public Task(String nome, String descricao, int prioridade) {
		
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.status = "Aberta";
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
