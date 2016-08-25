package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Cliente;

import com.htcursos.model.service.ClienteService;

@Named
public class ClienteConverter implements Converter {
	@Inject
	private ClienteService clienteService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Cliente cliente = clienteService.buscarPorId(Long.parseLong(id));
			return cliente;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object cliente) {
	
		if (cliente == null)
			return "";
		Cliente c = (Cliente) cliente;
		if (c.getId() == null)
			return null;

		return c.getId().toString();
	}
	}


