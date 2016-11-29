package br.com.sysfinanceiro.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.sysfinanceiro.model.entity.Banco;
import br.com.sysfinanceiro.model.entity.Cliente;
import br.com.sysfinanceiro.model.entity.Empresa;
import br.com.sysfinanceiro.model.entity.FormaPagamento;
import br.com.sysfinanceiro.model.entity.Fornecedor;
import br.com.sysfinanceiro.model.entity.Lancamento;
import br.com.sysfinanceiro.model.service.BancoService;
import br.com.sysfinanceiro.model.service.ClienteService;
import br.com.sysfinanceiro.model.service.EmpresaService;
import br.com.sysfinanceiro.model.service.FornecedorService;
import br.com.sysfinanceiro.model.service.LancamentoService;
import br.com.sysfinanceiro.model.service.ServiceException;

@Controller
@ViewScoped
public class LancamentoReceberBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Lancamento lancamento = new Lancamento();
	
	private List<Lancamento> lancamentoList;

	private FormaPagamento[] formaPagamento;
	private List<Cliente> clienteList;
	private List<Fornecedor> fornecedorList;
	private List<Empresa> empresaList;
	private List<Banco> bancoList;
	@Inject
	private LancamentoService lancamentoService;
	@Inject
	private EmpresaService empresaService;
	@Inject
	private FornecedorService fornecedorSevice;
	@Inject
	private ClienteService clienteService;
	@Inject
	private BancoService bancoService;

	@PostConstruct
	public void inicializar() {
		lancamentoList = lancamentoService.buscarTodos();
		empresaList = empresaService.buscarTodos();
		clienteList = clienteService.buscarTodos();
		fornecedorList = fornecedorSevice.buscarTodos();
		bancoList = bancoService.buscarTodos();
	}

	public void limpar() {
		lancamento = new Lancamento();
	}

	public void salvar() {
		try {
			lancamentoService.salvar(lancamento);
			// Limpar os dados
			lancamento = new Lancamento();
			// Atualiza lista
			lancamentoList = lancamentoService.buscarTodos();
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
		lancamentoService.excluir(lancamento);
		// Nova inst�ncia para limpar formul�rio
		lancamento = new Lancamento();
		// Atualiza lista
		lancamentoList = lancamentoService.buscarTodos();
	}

	public void buscarTodos() {
		lancamentoService.buscarTodos();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}


	public List<Lancamento> getLancamentoList() {
		return lancamentoList;
	}

	public void setLancamentoList(List<Lancamento> lancamentoList) {
		this.lancamentoList = lancamentoList;
	}

	public FormaPagamento[] getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento[] formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorList;
	}

	public void setFornecedorList(List<Fornecedor> fornecedorList) {
		this.fornecedorList = fornecedorList;
	}

	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}

	public List<Banco> getBancoList() {
		return bancoList;
	}

	public void setBancoList(List<Banco> bancoList) {
		this.bancoList = bancoList;
	}

	public LancamentoService getLancamentoService() {
		return lancamentoService;
	}

	public void setLancamentoService(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}


}
