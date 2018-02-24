package br.edu.ifpb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Resposta")
public class Resposta implements Comparable<Resposta>{
	@Id
	@Column(name="Res_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="Texto")
	private String texto;
	@Column(name="Res_Data")
	private String data;
	@OneToOne
	@JoinColumn(name="Id_Usuario")
	private Usuario uses;
	@ManyToOne
	@JoinColumn(name="Id_Postagem")
	private Postagem post;
	
	public Resposta(){}

	public Resposta(String texto, Usuario uses, String data, Postagem post) {
		super();
		this.texto = texto;
		this.data = data;
		this.uses = uses;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Usuario getUses() {
		return uses;
	}

	public void setUses(Usuario uses) {
		this.uses = uses;
	}

	public Postagem getPost() {
		return post;
	}

	public void setPost(Postagem post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", texto=" + texto + ", data=" + data + ", uses=" + uses + ", post=" + post + "]";
	}

	@Override
	public int compareTo(Resposta r) {
		// TODO Auto-generated method stub
		return this.id.compareTo(r.getId());
	}	

}
