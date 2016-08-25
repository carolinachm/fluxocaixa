package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;


import com.htcursos.model.entity.Empresa;
import com.htcursos.model.service.EmpresaService;
import com.htcursos.model.service.ServiceException;


@Controller
@ViewScoped
public class EmpresaBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Empresa empresa = new Empresa();
	
	
	private List<Empresa> empresaList;
	@Inject
	private EmpresaService empresaService;
	
	@PostConstruct
	public void inicializar(){
		empresaList = empresaService.buscarTodos();
	}
	
	public void limpar(){
		empresa = new Empresa();
	}
	
	public void salvar() {
		try {
			empresaService.salvar(empresa);
			// Limpar os dados
			empresa = new Empresa();
			// Atualiza lista
			empresaList = empresaService.buscarTodos();
			// Envia Mensagem para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Salvo com Sucesso!", null));
		} catch (ServiceException e) {
			// C�digo da mensagem de erro para Tela
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao Salvar: " + e.getMessage(), null));
			e.printStackTrace();
		}
	}

	public void excluir() {
		empresaService.excluir(empresa);
		// Nova inst�ncia para limpar formul�rio
		empresa = new Empresa();
		// Atualiza lista
		empresaList = empresaService.buscarTodos();
	}
	
	public void buscarTodos(){
		empresaService.buscarTodos();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}
	
	public boolean isEditando() {
		return this.empresa.getId() != null;
	}
	
}
