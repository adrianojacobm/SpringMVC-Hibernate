package br.com.adriano.springmvc_hibernate.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Produto;
import r.com.adriano.springmvc_hibernate.service.ProdutoServiceImpl;

@Controller
@RequestMapping("/")
public class HomeController
{
	private ProdutoServiceImpl produtosService = new ProdutoServiceImpl();
	
	@RequestMapping("/")
	public String PaginaInicialProdutos(Model model)
	{
		
		List<Produto> produtos = produtosService.getProdutos();
		
		model.addAttribute("produtos", produtos);
		
		return "index";
	}
	
	
}
