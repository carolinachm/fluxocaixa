package br.com.sysfinanceiro.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sysfinanceiro.model.entity.Permissao;
import br.com.sysfinanceiro.model.service.PermissaoService;

@Named
public class PermissaoConverter implements Converter {
	@Inject
	private PermissaoService permissaoService;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			Permissao permissao = permissaoService.buscarPorId(Long
					.parseLong(id));
			return permissao;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object permissao) {
		if (permissao == null) {
			return null; // Or an empty string, can also.
		}

		if (!(permissao instanceof Permissao)) {
			throw new ConverterException("The value is not a valid Permissao: "
					+ permissao);
		}

		Long id = ((Permissao) permissao).getId();
		return (id != null) ? String.valueOf(id) : null;
	}
}
