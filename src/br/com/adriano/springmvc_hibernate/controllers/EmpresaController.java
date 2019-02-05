package br.com.adriano.springmvc_hibernate.controllers;

import java.util.List;

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
import r.com.adriano.springmvc_hibernate.service.ProdutoService;


@Controller
@RequestMapping("/Empresa")
public class EmpresaController
{
	private EmpresaServiceImpl empresaService = new EmpresaServiceImpl();
	
	@RequestMapping("/NovaEmpresa")
	public String NovaEmpresa(Model model)
	{
		Empresa empresa = new Empresa();
		
		model.addAttribute("empresa",empresa);		
		
		return "NovaEmpresa";
	}
	
	@RequestMapping("/CadastrarEmpresa")
	@PostMapping
	public String CadastrarEmpresa(@ModelAttribute("produto") Empresa empresa)
	{
						
		empresaService.AdicionarAlterar(empresa);
		
		return"redirect:/Empresa/Empresas";
	}
	
	@RequestMapping("/EditarEmpresa")
	public String EditarEmpresa(@RequestParam("id") int id,Model model)
	{
		Empresa empresa = empresaService.getEmpresaPor(id);
		
		model.addAttribute("empresa",empresa);
		
		return "NovaEmpresa";
	}
	
	@RequestMapping("/ApagarEmpresa")
	public String ApagarEmpresa(@RequestParam("id") int id)
	{	
		Empresa empresa = empresaService.getEmpresaPor(id);		

		empresaService.Remover(empresa);
		
		return"redirect:/Empresa/Empresas";
	}
	
	@RequestMapping("/Empresas")
	public String PaginaInicialProdutos(Model model)
	{
		
		List<Empresa> empresas = empresaService.getEmpresas();
			
		model.addAttribute("empresas", empresas);
		
		return "/Empresas";
	}
	
	@RequestMapping("/ProdutosEmpresa")
	public String ProdutosEmpresa(Model model,@RequestParam("id") int id)
	{
		Empresa empresa = empresaService.getEmpresaPor(id);
		List<Produto> produtos = empresaService.getProdutosPorEmpresa(empresa);
		
		model.addAttribute("produtos", produtos);
		model.addAttribute("empresa", empresa);
		
		return "ProdutosEmpresa";
	}

}
