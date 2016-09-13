package com.htcursos.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.htcursos.model.entity.Categoria;
import com.htcursos.model.entity.SubCategoria;
import com.htcursos.model.service.CategoriaService;
import com.htcursos.model.service.SubCategoriaService;
import com.htcursos.model.service.ServiceException;


@Controller
@ViewScoped
public class SubCategoriaBean {
	/**
	 * Objeto que contera os dados da tela para salvar
	 * Objeto Vinculado ou Bindable com componente da tela
	 */
	private SubCategoria subCategoria = new SubCategoria();
	
	
	private List<SubCategoria> subCategoriaList;
	
	private List<Categoria> categoriaList;
	@Inject
	private SubCategoriaService subCategoriaService;
	@Inject
	private CategoriaService categoriaService;
	
	@PostConstruct
	public void inicializar(){
		subCategoriaList = subCategoriaService.buscarTodos();
		categoriaList = categoriaService.buscarTodos();
	}
	
	public void limpar(){
		subCategoria = new SubCategoria();
	}
	
	public void salvar() {
		try {
			subCategoriaService.salvar(subCategoria);
			// Limpar os dados
			subCategoria = new SubCategoria();
			// Atualiza lista
			subCategoriaList = subCategoriaService.buscarTodos();
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
		subCategoriaService.excluir(subCategoria);
		// Nova inst�ncia para limpar formul�rio
		subCategoria = new SubCategoria();
		// Atualiza lista
		subCategoriaList = subCategoriaService.buscarTodos();
	}
	
	public void buscarTodos(){
		subCategoriaService.buscarTodos();
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public List<SubCategoria> getSubCategoriaList() {
		return subCategoriaList;
	}

	public void setSubCategoriaList(List<SubCategoria> subCategoriaList) {
		this.subCategoriaList = subCategoriaList;
	}
	
	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public boolean isEditando() {
		return this.subCategoria.getId() != null;
	}
	
}
