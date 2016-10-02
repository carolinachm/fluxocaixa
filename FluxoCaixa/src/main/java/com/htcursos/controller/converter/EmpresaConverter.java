package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Empresa;

import com.htcursos.model.service.EmpresaService;

@Named
public class EmpresaConverter implements Converter {
	@Inject
	private EmpresaService empresaService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Empresa empresa = empresaService.buscarPorId(Long.parseLong(id));
			return empresa;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object empresa) {
	
		if (empresa == null)
			return "";
		Empresa b = (Empresa) empresa;
		if (b.getId() == null)
			return null;

		return b.getId().toString();
	}
	}


