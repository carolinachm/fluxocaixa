package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Fornecedor;

import com.htcursos.model.service.FornecedorService;

@Named
public class FornecedorConverter implements Converter {
	@Inject
	private FornecedorService fornecedorService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Fornecedor fornecedor = fornecedorService.buscarPorId(Long.parseLong(id));
			return fornecedor;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object fornecedor) {
	
		if (fornecedor == null)
			return "";
		Fornecedor b = (Fornecedor) fornecedor;
		if (b.getId() == null)
			return null;

		return b.getId().toString();
	}
	}


