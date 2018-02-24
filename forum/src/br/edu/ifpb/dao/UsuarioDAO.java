package br.edu.ifpb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.entity.Postagem;
import br.edu.ifpb.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer>{
	
	public UsuarioDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public UsuarioDAO(EntityManager em) {
		super(em);
	}
	
	public Usuario findByLogin(String login) {
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.login = :login");
		q.setParameter("login", login);
		Usuario usuario = null;
		try {
			usuario = (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return usuario;
	}
	
	public Usuario findByName(String nome) {
		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.nome = :nome");
		q.setParameter("nome", nome);
		Usuario usuario = null;
		try {
			usuario = (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return usuario;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll(){
		Query q = this.getEntityManager().createQuery("select u from Usuario u");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Postagem> findAllPostagens(Usuario usuario){
		Query q = this.getEntityManager().createQuery("from Postagem p where p.dono = :user");
		q.setParameter("user", usuario);
		return q.getResultList();
	}

}
