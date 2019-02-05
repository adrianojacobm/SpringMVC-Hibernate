import java.util.List;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Produto;
import br.com.adriano.springmvc_hibernate.entities.Vendedor;
import r.com.adriano.springmvc_hibernate.service.EmpresaServiceImpl;
import r.com.adriano.springmvc_hibernate.service.ProdutoServiceImpl;
import r.com.adriano.springmvc_hibernate.service.VendedorServiceImpl;

public class Teste
{

	public static void main(String[] args)
	{
		
		//Produto produto = new Produto("Pera",6.66);
		
/*		ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
		
		Produto produto = produtoService.getProdutoPor(6);
		
		produto.setNome("Maçã Argentina");
		
		produto.setPreco(25.6);
		
		produtoService.AdicionarAlterar(produto);
*/
		
//		EmpresaServiceImpl empresaService = new EmpresaServiceImpl();
//		
//		VendedorServiceImpl vendedorService = new VendedorServiceImpl();
//	
//		Empresa empresa = empresaService.getEmpresaPor(1);
//
//
//
//		
//		
//		for(Vendedor vendedores : empresa.getVendedores())
//		{
//			System.out.println(vendedores.getNome());
//		}


		
//		empresa.setNome("Empresa01");
//		empresa.setCnpj("00000000");
//		empresa.setEndereco("Av 123");
//		
//		
//		Vendedor vendedor = new Vendedor();
//		
//		vendedor.setNome("Joao");
//						
//		Vendedor vendedor2 = new Vendedor();
//		
//		vendedor2.setNome("Maria");
//		
//		Vendedor vendedor3 = new Vendedor();
//		
//		vendedor3.setNome("Jose");
//		
////		vendedorService.AdicionarAlterar(vendedor);
////		vendedorService.AdicionarAlterar(vendedor2);
////		vendedorService.AdicionarAlterar(vendedor3);
//		
//
//		
////		Vendedor vendedor = vendedorService.getVendedorPor(1);
////		Vendedor vendedor2 = vendedorService.getVendedorPor(2);
////		Vendedor vendedor3 = vendedorService.getVendedorPor(3);
//		
//		empresa.adicionarVendedor(vendedor);
//		empresa.adicionarVendedor(vendedor2);
//		empresa.adicionarVendedor(vendedor3);
//		
//		empresaService.AdicionarAlterar(empresa);
		
		
		EmpresaServiceImpl empresaService = new EmpresaServiceImpl();
		ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
		
		//HibernateFactory.openSession();
		
		Produto produto = produtoService.getProdutoPor(4);
		
		//HibernateFactory.closeSession();
		
		//produto.setPreco(6.67);
		
		System.out.println(produto.VerificaEmpresa(1));

		
		//HibernateFactory.openSession();
				
		//Empresa empresa = empresaService.getEmpresaPor(1);
		
		//produtoService.setEmpresa(produto.getId(),empresa.getId());
		
		//produtoService.getEmpresas(produto);
		
		//empresa.PreencherProdutos();
		
		//for(Produto produto : empresa.getProdutos())
			//System.out.println(produto.getNome());
		
		//Empresa empresa = empresaService.getEmpresaPor(1);
		
		
		//produtoService.AdicionarAlterar(produto);
		
		//HibernateFactory.closeSession();
		

	}

}
