package com.htcursos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.entity.Conta;
import com.htcursos.model.entity.TipoConta;
import com.htcursos.model.service.ContaService;
import com.htcursos.model.service.ServiceException;

@Controller
@ViewScoped
public class ContaBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Conta conta = new Conta();

	private List<Conta> contaList;
	@Inject
	private ContaService contaService;

	private TipoConta[] tipos;

	@PostConstruct
	public void inicializar() {
		contaList = contaService.buscarTodos();
	}

	public void limpar() {
		conta = new Conta();
	}

	public void salvar() {
		try {
			contaService.salvar(conta);
			// Limpar os dados
			conta = new Conta();
			// Atualiza lista
			contaList = contaService.buscarTodos();
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
		contaService.excluir(conta);
		// Nova inst�ncia para limpar formul�rio
		conta = new Conta();
		// Atualiza lista
		contaList = contaService.buscarTodos();
	}

	public void buscarTodos() {
		contaService.buscarTodos();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContaList() {
		return contaList;
	}

	public void setContaList(List<Conta> contaList) {
		this.contaList = contaList;
	}

	public TipoConta[] getTipos() {
		return TipoConta.values();
	}

	public void setTipos(TipoConta[] tipos) {
		this.tipos = tipos;
	}

	public boolean isEditando() {
		return this.conta.getId() != null;
	}

	public void tornarFavorita() throws DAOException {
		contaService.tornarFavorita(conta);
		conta = new Conta();
	}

}
