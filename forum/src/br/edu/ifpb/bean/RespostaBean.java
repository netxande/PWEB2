package br.edu.ifpb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifpb.entity.Resposta;

@ManagedBean(name="respostabean")
public class RespostaBean {
	private List<Resposta> respostas;
	
	public void init() {
		this.respostas = new ArrayList<Resposta>();
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
}
