package br.edu.ifpb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.entity.Resposta;
import br.edu.ifpb.entity.Usuario;

public class RespostaDAO extends GenericDAO<Resposta, Integer>{
	
	public RespostaDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public RespostaDAO(EntityManager em) {
		super(em);
	}
	
	public List<Resposta> findAllFromUser(Usuario usuario){
		Query q = this.getEntityManager().createQuery("from Resposta r where r.uses = :user");
		q.setParameter("user", usuario);
		return q.getResultList();
	}
	
	public List<Resposta> findPesquisaResposta(Usuario usuario, String busca){
		Query q = this.getEntityManager().createQuery("from Resposta r where r.uses = :user and "
				+ "LOWER(r.texto) LIKE :busca");
		q.setParameter("user", usuario);
		q.setParameter("busca", "%" + busca + "%");
		
		if(q.getResultList().isEmpty()){
			q = this.getEntityManager().createQuery("from Resposta r where r.uses = :user and "
					+ "LOWER(r.id) LIKE :busca");
			q.setParameter("user", usuario);
			q.setParameter("busca", "%" + busca + "%");
		}
		return q.getResultList();
	}


}
