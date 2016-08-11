package com.htcursos.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;
import com.htcursos.model.service.CidadeService;

@Named
public class CidadeConverter implements Converter {
	@Inject
	private CidadeService cidadeService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Cidade cidade = cidadeService.buscarPorId(Long.parseLong(id));
			return cidade;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object cidade) {

		if (cidade == null) {
			return null; // Or an empty string, can also.
		}

		if (!(cidade instanceof Cidade)) {
			throw new ConverterException("The value is not a valid Cidade: "
					+ cidade);
		}

		Long id = ((Cidade) cidade).getId();
		return (id != null) ? String.valueOf(id) : null;
	}
}
