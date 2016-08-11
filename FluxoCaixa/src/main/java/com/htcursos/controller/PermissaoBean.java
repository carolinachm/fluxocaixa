package com.htcursos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Permissao;
import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.PermissaoService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class PermissaoBean {
	/**
	 * Objeto que contera os dados da tela para salvar Objeto Vinculado ou
	 * Bindable com componente da tela
	 */
	private Permissao permissao = new Permissao();

	private List<Permissao> permissaoList;
	@Inject
	private PermissaoService permissaoService;

	@PostConstruct
	public void inicializar() {
		permissaoList = permissaoService.buscarTodos();
	}

	public void limpar() {
		permissao = new Permissao();
	}

	public void salvar() throws ServiceException {
		permissaoService.salvar(permissao);
		limpar();
		permissaoList = permissaoService.buscarTodos();
		FacesUtil.addInfoMessage("Permissao salvo com sucesso");
	}

	public void excluir() throws ServiceException {
		permissaoService.excluir(permissao);
		limpar();
		permissaoList = permissaoService.buscarTodos();
		FacesUtil.addInfoMessage("Permissao excluido com sucesso");
	}

	public void buscarTodos() {
		permissaoService.buscarTodos();
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public List<Permissao> getPermissaoList() {
		return permissaoList;
	}

	public void setPermissaoList(List<Permissao> permissaoList) {
		this.permissaoList = permissaoList;
	}

}
