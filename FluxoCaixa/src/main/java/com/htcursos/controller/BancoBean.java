package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Banco;
import com.htcursos.model.entity.TipoConta;
import com.htcursos.model.service.BancoService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class BancoBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Banco banco = new Banco();
	
	private TipoConta[] tipoconta;
	
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
	
	public void salvar() throws ServiceException{
		bancoService.salvar(banco);
		limpar();
		bancoList = bancoService.buscarTodos();
		FacesUtil.addInfoMessage("Banco salvo com sucesso");
	}
	public void excluir() throws ServiceException{
		bancoService.excluir(banco);
		limpar();
		bancoList = bancoService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
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

	public TipoConta[] getTipoconta() {
		return TipoConta.values();
	}

	public void setTipoconta(TipoConta[] tipoconta) {
		this.tipoconta = tipoconta;
	}

	
}
