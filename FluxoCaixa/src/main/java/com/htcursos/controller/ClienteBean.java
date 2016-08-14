package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Cliente;
import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.service.ClienteService;
import com.htcursos.model.service.PessoaService;
import com.htcursos.model.service.ServiceException;

@Controller
@ViewScoped
public class ClienteBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Cliente cliente = new Cliente();
	
	private List<Pessoa> pessoaList;
	
	private List<Cliente> clienteList;
	@Inject
	private ClienteService clienteService;
	@Inject
	private PessoaService pessoaService;
	
	@PostConstruct
	public void inicializar(){
			clienteList = clienteService.buscarTodos();
			pessoaList = pessoaService.buscarTodos();
	}
	
	public void limpar(){
		cliente = new Cliente();
	}
	
	public void salvar() {
		try {
			clienteService.salvar(cliente);
			// Limpar os dados
			cliente = new Cliente();
			// Atualiza lista
			clienteList = clienteService.buscarTodos();
			
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
		clienteService.excluir(cliente);
		// Nova inst�ncia para limpar formul�rio
		cliente = new Cliente();
		// Atualiza lista
		clienteList = clienteService.buscarTodos();
	}
	
	public void buscarTodos(){
		clienteService.buscarTodos();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}
	public boolean isEditando() {
		return this.cliente.getId() != null;
	}
	
}
