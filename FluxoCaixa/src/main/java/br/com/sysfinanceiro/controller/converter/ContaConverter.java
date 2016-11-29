package br.com.sysfinanceiro.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sysfinanceiro.model.entity.Conta;
import br.com.sysfinanceiro.model.service.ContaService;

@Named
public class ContaConverter implements Converter {
	@Inject
	private ContaService contaService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Conta conta = contaService.buscarPorId(Long.parseLong(id));
			return conta;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object conta) {
		if (conta == null)
			return "";
		Conta c = (Conta) conta;
		if (c.getId() == null)
			return null;

		return c.getId().toString();
	}
}
