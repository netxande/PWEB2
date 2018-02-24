package br.edu.ifpb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.entity.Postagem;
import br.edu.ifpb.entity.Tema;
import br.edu.ifpb.entity.Usuario;

public class PostagemDAO extends GenericDAO<Postagem, Integer>{
	
	public PostagemDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public PostagemDAO(EntityManager em) {
		super(em);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Postagem> findByTitulo(String busca) {
		Query q = this.getEntityManager().createQuery("select p from Postagem p where p.titulo like :busca");
		q.setParameter("busca", busca+"%");
		return q.getResultList();
	}
	
	public List<Postagem> findPostagemTema(Tema tema){
		Query q = this.getEntityManager().createQuery("select p from Postagem p where p.tema = :tema");
		q.setParameter("tema", tema);
		return q.getResultList();
	}
	
	public Postagem findById(Integer id) {
		Query q = this.getEntityManager().createQuery("select p from Postagem p where p.id = :id");
		q.setParameter("id", id);
		Postagem postagem = null;
		try {
			postagem = (Postagem) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return postagem;
	}
	
	public List<Postagem> findAllFromUser(Usuario usuario){
		Query q = this.getEntityManager().createQuery("from Postagem p where p.dono = :user");
		q.setParameter("user", usuario);
		return q.getResultList();
	}

}
