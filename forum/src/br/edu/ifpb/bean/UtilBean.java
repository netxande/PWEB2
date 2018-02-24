package br.edu.ifpb.bean;

import java.util.List;

import br.edu.ifpb.dao.PersistenceUtil;
import br.edu.ifpb.dao.PostagemDAO;
import br.edu.ifpb.dao.RespostaDAO;
import br.edu.ifpb.entity.Postagem;
import br.edu.ifpb.entity.Resposta;

public class UtilBean {
	
	public List<Postagem> getPostagens(){
		PostagemDAO dao = new PostagemDAO(PersistenceUtil.getCurrentEntityManager());
		List<Postagem> postagens = dao.findAll();
		return postagens;
	}
	
	public List<Resposta> getRespostas(){
		RespostaDAO dao = new RespostaDAO(PersistenceUtil.getCurrentEntityManager());
		List<Resposta> respostas = dao.findAll();
		return respostas;
	}

}
