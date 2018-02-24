package br.edu.ifpb.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.entity.Postagem;
import br.edu.ifpb.entity.Tema;


public class TemaDAO extends GenericDAO<Tema, Integer>{
	public TemaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public TemaDAO(EntityManager em) {
		super(em);
	}
	
	public Tema findById(Integer id) {
		Query q = this.getEntityManager().createQuery("select t from Tema t where t.id = :id");
		q.setParameter("id", id);
		Tema tema = null;
		try {
			tema = (Tema) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return tema;
	}
	
	public Tema findByDescricao(String descricao) {
		Query q = this.getEntityManager().createQuery("select t from Tema t where t.descricao = :descricao");
		q.setParameter("descricao", descricao);
		Tema tema = null;
		try {
			tema =  (Tema) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return tema;
	}
	
	
}
