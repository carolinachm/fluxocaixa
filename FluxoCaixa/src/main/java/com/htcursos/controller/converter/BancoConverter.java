package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Banco;
import com.htcursos.model.service.BancoService;

@Named
public class BancoConverter implements Converter {
	@Inject
	private BancoService bancoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Banco banco = bancoService.buscarPorId(Long.parseLong(id));
			return banco;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object banco) {
	
		   if (banco == null) {
	            return null; // Or an empty string, can also.
	        }

	        if (!(banco instanceof Banco)) {
	            throw new ConverterException("The value is not a valid Banco: " + banco);
	        }

	       Long id = ((Banco)banco).getId();
	        return (id != null) ? String.valueOf(id) : null;
	    }
	}


