package r.com.adriano.springmvc_hibernate.service;

import java.util.List;

import br.com.adriano.springmvc_hibernate.entities.Empresa;

public interface EmpresaService
{
	public void AdicionarAlterar(Empresa empresa);
	
	public void Remover(Empresa empresa);
		
	public List<Empresa> getEmpresas();
	
	public Empresa getEmpresaPor(int id);

}
