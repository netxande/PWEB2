package br.edu.ifpb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Postagem")
public class Postagem implements Comparable<Postagem>{
	@Id
	@Column(name="Po_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="Titulo")
	private String titulo;
	@Column(name="Conteudo")
	private String conteudo;
	@Column(name="Pos_Data")
	private String data;
	@OneToOne
	@JoinColumn(name="Id_Usuario")
	private Usuario dono;
	@ManyToOne
	@JoinColumn(name="Id_Tema")
	private Tema tema;
	@OneToMany(mappedBy="post", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=false)
	private List<Resposta> repostas;
	
	public Postagem(){}

	public Postagem(String titulo, String conteudo, String data, Usuario dono, Tema tema) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.data = data;
		this.dono = dono;
		this.tema = tema;
		this.repostas = new ArrayList<Resposta>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public void adicionarResposta(Resposta resp) {
		this.repostas.add(resp);
		resp.setPost(this);
	}
	
	public void removerResposta(Resposta resp) {
		this.repostas.remove(resp);
		resp.setPost(null);
	}
	
	public List<Resposta> getRepostas() {
		return repostas;
	}

	public void setRepostas(List<Resposta> repostas) {
		this.repostas = repostas;
	}

	@Override
	public String toString() {
		return "Postagem [id=" + id + ", titulo=" + titulo + ", data=" + data + ", dono=" + dono + ", tema=" + tema
				+ "]";
	}

	@Override
	public int compareTo(Postagem p) {
		// TODO Auto-generated method stub
		//return this.data.compareTo(p.getData());
		return this.titulo.compareToIgnoreCase(p.getTitulo());
	}

}
