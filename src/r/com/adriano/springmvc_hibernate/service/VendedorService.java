package r.com.adriano.springmvc_hibernate.service;

import java.util.List;
import br.com.adriano.springmvc_hibernate.entities.Vendedor;

public interface VendedorService
{

	public void AdicionarAlterar(Vendedor vendedor);
	
	public void Remover(Vendedor vendedor);
		
	public List<Vendedor> getVendedores();
	
	public Vendedor getVendedorPor(int id);
}
