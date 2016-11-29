package br.com.sysfinanceiro.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.sysfinanceiro.model.entity.Banco;
import br.com.sysfinanceiro.model.entity.TipoConta;
import br.com.sysfinanceiro.model.service.BancoService;
import br.com.sysfinanceiro.model.service.ServiceException;
import br.com.sysfinanceiro.model.util.FacesUtil;

@Controller
@ViewScoped
public class BancoBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Banco banco = new Banco();
	
	
	private List<Banco> bancoList;
	@Inject
	private BancoService bancoService;
	
	@PostConstruct
	public void inicializar(){
		bancoList = bancoService.buscarTodos();
	}
	
	public void limpar(){
		banco = new Banco();
	}
	
	public void salvar() {
		try {
			bancoService.salvar(banco);
			// Limpar os dados
			banco = new Banco();
			// Atualiza lista
			bancoList = bancoService.buscarTodos();
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
		bancoService.excluir(banco);
		// Nova inst�ncia para limpar formul�rio
		banco = new Banco();
		// Atualiza lista
		bancoList = bancoService.buscarTodos();
	}
	
	public void buscarTodos(){
		bancoService.buscarTodos();
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<Banco> getBancoList() {
		return bancoList;
	}

	public void setBancoList(List<Banco> bancoList) {
		this.bancoList = bancoList;
	}
	
	public boolean isEditando() {
		return this.banco.getId() != null;
	}
	
}
