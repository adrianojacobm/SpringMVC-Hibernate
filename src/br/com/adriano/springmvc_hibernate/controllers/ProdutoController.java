package br.com.adriano.springmvc_hibernate.controllers;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Produto;
import r.com.adriano.springmvc_hibernate.service.EmpresaServiceImpl;
import r.com.adriano.springmvc_hibernate.service.ProdutoServiceImpl;

@Controller
@RequestMapping("/Produto")
public class ProdutoController
{
	public ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
	public EmpresaServiceImpl empresaService = new EmpresaServiceImpl();

	@RequestMapping("/NovoProduto")
	public String NovoProduto(Model model)
	{
		try
		{			
			Produto produto = new Produto();
			
			List<Empresa> empresas = empresaService.getEmpresas();
			
			model.addAttribute("produto",produto);	
			model.addAttribute("empresas",empresas);	
									
			return "NovoProduto";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "NovoProduto";
		}		

	}
	
	@RequestMapping("/CadastrarProduto")
	@PostMapping
	public String CadastrarProduto(@ModelAttribute("produto") Produto produto,HttpServletRequest request)
	{
		try
		{
		
			Produto produtoEditar = produtoService.getProdutoPor(produto.getId());
			if(produtoEditar == null)
			{
				String[] empresasid= request.getParameterValues("empresasid");
				

				
				if(empresasid == null)
				{
					produtoService.AdicionarAlterar(produto);
				}
				else
				{
					for(String empresaid : empresasid)
					{
						if(empresaid != null)
						{
							//produto pertence a empresa marcada
							Empresa empresa = empresaService.getEmpresaPor(Integer.parseInt(empresaid));
							produto.adicionarEmpresa(empresa);
							
						}
					}
					produtoService.AdicionarAlterar(produto);				
				}							

			}
				
			else
			{				
				String[] empresasid= request.getParameterValues("empresasid");
				
				if(empresasid == null)
				{
					produtoEditar.setNome(produto.getNome());
					produtoEditar.setPreco(produto.getPreco());
					
					produtoService.AdicionarAlterar(produtoEditar);					
				}
				else
				{
					for(String empresaid : empresasid)
					{
						if(empresaid != null)
						{
							Empresa empresa = empresaService.getEmpresaPor(Integer.parseInt(empresaid));
							if(!produtoEditar.getEmpresas().contains(empresa))
								produtoService.setEmpresa(produtoEditar.getId(), empresa.getId());
							
						}


					}
						produtoEditar.setNome(produto.getNome());
						produtoEditar.setPreco(produto.getPreco());						
						produtoService.AdicionarAlterar(produtoEditar);					
				}
			
		
			}

						
			return"redirect:/";			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return"redirect:/";		
		}

	}
	
	@RequestMapping("/EditarProduto")
	public String EditarProduto(@RequestParam("id") int id,Model model)
	{
		try
		{			
			Produto produto = produtoService.getProdutoPor(id);
			
			produtoService.setEmpresasPor(produto);
			
			List<Empresa> empresas = empresaService.getEmpresas();
			
			model.addAttribute("produto",produto);	
			model.addAttribute("empresas",empresas);				
			
			return "NovoProduto";			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "NovoProduto";		
		}

	}
	
	@RequestMapping("/ApagarProduto")
	public String ApagarProduto(@RequestParam("id") int id)
	{
		try
		{
			
			Produto produto = produtoService.getProdutoPor(id);
			
			produtoService.setEmpresasPor(produto);
			
			produtoService.Remover(produto);
			
			return"redirect:/";			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return"redirect:/";	
		}

	}
}
