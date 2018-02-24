
package br.edu.ifpb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifpb.dao.TemaDAO;
import br.edu.ifpb.entity.Tema;

@ManagedBean(name="temabean")
public class TemaBean {
	private List<Tema> temas;
	private String desc;
	
	public void init() {
		this.temas = new ArrayList<Tema>();
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public void listar() {
		TemaDAO dao = new TemaDAO();
		this.temas = dao.findAll();
	}
}
