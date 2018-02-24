package br.edu.ifpb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifpb.dao.PostagemDAO;
import br.edu.ifpb.dao.TemaDAO;
import br.edu.ifpb.entity.Postagem;
import br.edu.ifpb.entity.Tema;

@ManagedBean(name="postagembean")
public class PostagemBean {
	private String busca;
	private List<Postagem> postagens;
	
	public void init() {
		this.postagens = new ArrayList<Postagem>();
	}
	
	public List<Postagem> getPostagens() {
		return postagens;
	}
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	
	public void listar() {
		PostagemDAO dao = new PostagemDAO();
		this.postagens = dao.findAll();
	}
	
	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public void consulta() {
		PostagemDAO dao = new PostagemDAO();
		this.postagens = dao.findByTitulo(this.busca);
		setBusca(null);
	}
	
	public String consultaTema() {
		PostagemDAO dao = new PostagemDAO();
		TemaDAO daoTema = new TemaDAO();
		Tema tema = daoTema.findByDescricao(this.busca);
		this.postagens = dao.findPostagemTema(tema);
		setBusca(null);
		return "tema";
	}

}
