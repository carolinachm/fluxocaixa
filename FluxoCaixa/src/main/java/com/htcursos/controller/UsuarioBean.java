package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Permissao;
import com.htcursos.model.entity.Pessoa;
import com.htcursos.model.entity.Usuario;
import com.htcursos.model.service.PermissaoService;
import com.htcursos.model.service.PessoaService;
import com.htcursos.model.service.ServiceException;
import com.htcursos.model.service.UsuarioService;
import com.htcursos.model.util.FacesUtil;

@Controller
@ViewScoped
public class UsuarioBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarioList;
	
	private List<Pessoa> pessoaList;

	private List<Permissao> permissaoList;
	@Inject
	private UsuarioService usuarioService;
	@Inject
	private PessoaService pessoaService;
	@Inject
	private PermissaoService permissaoService;
	
	@PostConstruct
	public void inicializar(){
		usuarioList = usuarioService.buscarTodos();
		pessoaList  = pessoaService.buscarTodos();
		permissaoList = permissaoService.buscarTodos();
	}
	
	public void limpar(){
		usuario = new Usuario();
	}
	
	public void salvar() throws ServiceException{
		usuarioService.salvar(usuario);
		limpar();
		usuarioList = usuarioService.buscarTodos();
		permissaoList = permissaoService.buscarTodos();
		pessoaList = pessoaService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso");
	}
	public void excluir() throws ServiceException{
		usuarioService.excluir(usuario);
		limpar();
		usuarioList = usuarioService.buscarTodos();
		pessoaList = pessoaService.buscarTodos();
		FacesUtil.addInfoMessage("Usuário excluido com sucesso");
	}
	
	public void buscarTodos(){
		usuarioService.buscarTodos();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

	public void setPessoaList(List<Pessoa> pessoaList) {
		this.pessoaList = pessoaList;
	}

	public List<Permissao> getPermissaoList() {
		return permissaoList;
	}

	public void setPermissaoList(List<Permissao> permissaoList) {
		this.permissaoList = permissaoList;
	}

}
