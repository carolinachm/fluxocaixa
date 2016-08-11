package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Estado;
import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.EstadoService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class EstadoBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Estado estado = new Estado();
	
	private List<Estado> estadoList;
	@Inject
	private EstadoService estadoService;
	
	@PostConstruct
	public void inicializar(){
			estadoList = estadoService.buscarTodos();
	}
	
	public void limpar(){
		estado = new Estado();
	}
	
	public void salvar() throws ServiceException{
		estadoService.salvar(estado);
		limpar();
		estadoList = estadoService.buscarTodos();
		FacesUtil.addInfoMessage("Estado salvo com sucesso");
	}
	public void excluir() throws ServiceException{
		estadoService.excluir(estado);
		limpar();
		estadoList = estadoService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
	}
	
	public void buscarTodos(){
		estadoService.buscarTodos();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

	
}
