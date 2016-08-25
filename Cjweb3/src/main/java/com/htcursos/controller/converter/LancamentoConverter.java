package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Lancamento;

import com.htcursos.model.service.LancamentoService;

@Named
public class LancamentoConverter implements Converter {
	@Inject
	private LancamentoService lancamentoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Lancamento lancamento = lancamentoService.buscarPorId(Long.parseLong(id));
			return lancamento;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object lancamento) {
	
		if (lancamento == null)
			return "";
		Lancamento l = (Lancamento) lancamento;
		if (l.getId() == null)
			return null;

		return l.getId().toString();
	}
	}


