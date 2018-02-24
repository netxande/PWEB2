package br.edu.ifpb.entity;

public enum Perfil {
	BASIC("Básico"),
	ADM("Administrador");
	
	private String nome;

	private Perfil(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}
