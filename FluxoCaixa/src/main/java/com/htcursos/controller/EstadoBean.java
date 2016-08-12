package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	public void salvar() {
		try {
			estadoService.salvar(estado);
			// Limpar os dados
			limpar();
			// Atualiza lista
			estadoList = estadoService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// Código da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}

	public void excluir() {
		estadoService.excluir(estado);
		// Nova instância para limpar formulário
		limpar();
		// Atualiza lista
		estadoList = estadoService.buscarTodos();
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
