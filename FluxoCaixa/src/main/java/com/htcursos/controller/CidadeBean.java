package com.htcursos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.CidadeService;
import com.htcursos.model.service.EstadoService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class CidadeBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Cidade cidade = new Cidade();

	private List<Cidade> cidadeList;

	private List<Estado> estadoList;
	@Inject
	private CidadeService cidadeService;
	@Inject
	private EstadoService estadoService;
	

	@PostConstruct
	public void inicializar() {
		cidadeList = cidadeService.buscarTodos();
		estadoList = estadoService.buscarTodos();
	}

	public void limpar() {
		cidade = new Cidade();
	}

	public void salvar() throws ServiceException {
		cidadeService.salvar(cidade);
		limpar();
		cidadeList = cidadeService.buscarTodos();
		estadoList = estadoService.buscarTodos();
		FacesUtil.addInfoMessage("Cidade salvo com sucesso");
	}

	public void excluir() throws ServiceException {
		cidadeService.excluir(cidade);
		limpar();
		cidadeList = cidadeService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
	}

	public void buscarCidades(ValueChangeEvent evento) {
		if(evento.getNewValue() != evento.getOldValue()) {
			Estado estado = (Estado)evento.getNewValue();
			
			cidadeList = cidadeService.buscarCidades(estado);
		}
	}

	public void buscarTodos() {
		cidadeService.buscarTodos();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidadeList() {
		return cidadeList;
	}

	public void setCidadeList(List<Cidade> cidadeList) {
		this.cidadeList = cidadeList;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}



}
