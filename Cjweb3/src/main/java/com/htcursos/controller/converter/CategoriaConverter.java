package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Categoria;

import com.htcursos.model.service.CategoriaService;

@Named
public class CategoriaConverter implements Converter {
	@Inject
	private CategoriaService categoriaService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Categoria categoria = categoriaService.buscarPorId(Long.parseLong(id));
			return categoria;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object categoria) {
	
		if (categoria == null)
			return "";
		Categoria b = (Categoria) categoria;
		if (b.getId() == null)
			return null;

		return b.getId().toString();
	}
	}


