package com.htcursos.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.EstadoService;
import com.htcursos.model.service.PessoaService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class PessoaBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Pessoa pessoa;

	private List<Pessoa> pessoaList;

	private List<Estado> estadoList;
	@Inject
	private PessoaService pessoaService;
	@Inject
	private EstadoService estadoService;

	@PostConstruct
	public void inicializar() {
		pessoa = new Pessoa();
		pessoa.setCidade(new Cidade());
		pessoaList = pessoaService.buscarTodos();
		estadoList = estadoService.buscarTodos();
	}

	public void limpar() {
		pessoa = new Pessoa();
	}

	public void salvar() {
		try {
			pessoaService.salvar(pessoa);
			// Limpar os dados
			limpar();
			// Atualiza lista
			pessoaList = pessoaService.buscarTodos();
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
		pessoaService.excluir(pessoa);
		// Nova instância para limpar formulário
		limpar();
		// Atualiza lista
		pessoaList = pessoaService.buscarTodos();
	}

	public void buscarTodos() {
		pessoaService.buscarTodos();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

}
