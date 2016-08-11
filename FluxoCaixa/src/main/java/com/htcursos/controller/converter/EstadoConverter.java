package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.EstadoService;

@Named
public class EstadoConverter implements Converter {
	@Inject
	private EstadoService estadoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Estado estado = estadoService.buscarPorId(Long.parseLong(id));
			return estado;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object estado) {
	
		   if (estado == null) {
	            return null; // Or an empty string, can also.
	        }

	        if (!(estado instanceof Estado)) {
	            throw new ConverterException("The value is not a valid Estado: " + estado);
	        }

	       Long id = ((Estado)estado).getId();
	        return (id != null) ? String.valueOf(id) : null;
	    }
	}


