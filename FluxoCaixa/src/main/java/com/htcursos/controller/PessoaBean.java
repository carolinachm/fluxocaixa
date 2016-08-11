package com.htcursos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.EstadoService;
import com.htcursos.model.service.PessoaService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class PessoaBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Pessoa pessoa = new Pessoa();

	private List<Pessoa> pessoaList;

	private List<Estado> estadoList;
	@Inject
	private PessoaService pessoaService;
	@Inject
	private EstadoService estadoService;

	@PostConstruct
	public void inicializar() {
		pessoa.setCidade(new Cidade());
		pessoaList = pessoaService.buscarTodos();
		estadoList = estadoService.buscarTodos();
	}

	public void limpar() {
		pessoa = new Pessoa();
	}

	public void salvar() throws ServiceException {
		pessoaService.salvar(pessoa);
		limpar();
		pessoaList = pessoaService.buscarTodos();
		FacesUtil.addInfoMessage("Pessoa salvo com sucesso");
	}

	public void excluir() throws ServiceException {
		pessoaService.excluir(pessoa);
		limpar();
		pessoaList = pessoaService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
	}

	public void buscarPessoas(ValueChangeEvent evento) {
		if (evento.getNewValue() != evento.getOldValue()) {
			Estado estado = (Estado) evento.getNewValue();
			pessoaList = pessoaService.buscarPessoas(estado);
		}

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
