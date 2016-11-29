package br.com.sysfinanceiro.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sysfinanceiro.model.entity.Banco;
import br.com.sysfinanceiro.model.service.BancoService;

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
	
		if (banco == null)
			return "";
		Banco b = (Banco) banco;
		if (b.getId() == null)
			return null;

		return b.getId().toString();
	}
	}


