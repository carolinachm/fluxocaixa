package br.com.sysfinanceiro.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sysfinanceiro.model.entity.Cidade;
import br.com.sysfinanceiro.model.service.CidadeService;

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
		if (cidade == null)
			return "";
		Cidade c = (Cidade) cidade;
		if (c.getId() == null)
			return null;

		return c.getId().toString();
	}
}
