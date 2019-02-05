package r.com.adriano.springmvc_hibernate.service;

import java.util.List;

import br.com.adriano.springmvc_hibernate.entities.Produto;

public interface ProdutoService
{

	public void AdicionarAlterar(Produto produto);
	
	public void Remover(Produto produto);
		
	public List<Produto> getProdutos();
	
	public Produto getProdutoPor(int id);
}
