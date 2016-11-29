package br.com.sysfinanceiro.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.sysfinanceiro.model.entity.Fornecedor;
import br.com.sysfinanceiro.model.service.FornecedorService;
import br.com.sysfinanceiro.model.service.ServiceException;

@Controller
@ViewScoped
public class FornecedorBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Fornecedor fornecedor = new Fornecedor();
	
	
	private List<Fornecedor> fornecedorList;
	@Inject
	private FornecedorService fornecedorService;
	
	@PostConstruct
	public void inicializar(){
		fornecedorList = fornecedorService.buscarTodos();
	}
	
	public void limpar(){
		fornecedor = new Fornecedor();
	}
	
	public void salvar() {
		try {
			fornecedorService.salvar(fornecedor);
			// Limpar os dados
			fornecedor = new Fornecedor();
			// Atualiza lista
			fornecedorList = fornecedorService.buscarTodos();
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
		fornecedorService.excluir(fornecedor);
		// Nova inst�ncia para limpar formul�rio
		fornecedor = new Fornecedor();
		// Atualiza lista
		fornecedorList = fornecedorService.buscarTodos();
	}
	
	public void buscarTodos(){
		fornecedorService.buscarTodos();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorList;
	}

	public void setFornecedorList(List<Fornecedor> fornecedorList) {
		this.fornecedorList = fornecedorList;
	}
	
	public boolean isEditando() {
		return this.fornecedor.getId() != null;
	}
	
}
