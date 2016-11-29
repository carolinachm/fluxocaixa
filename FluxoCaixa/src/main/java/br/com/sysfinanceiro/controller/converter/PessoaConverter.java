package br.com.sysfinanceiro.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sysfinanceiro.model.entity.Estado;
import br.com.sysfinanceiro.model.entity.Pessoa;
import br.com.sysfinanceiro.model.service.PessoaService;

@Named
public class PessoaConverter implements Converter {
	@Inject
	private PessoaService pessoaService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Pessoa pessoa = pessoaService.buscarPorId(Long.parseLong(id));
			return pessoa;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object pessoa) {

		if (pessoa == null)
			return "";
		Pessoa p = (Pessoa) pessoa;
		if (p.getId() == null)
			return null;

		return p.getId().toString();
	}

}
