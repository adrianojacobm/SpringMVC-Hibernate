package br.com.adriano.springmvc_hibernate.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Vendedor;
import r.com.adriano.springmvc_hibernate.service.EmpresaServiceImpl;
import r.com.adriano.springmvc_hibernate.service.VendedorServiceImpl;

@Controller
@RequestMapping("/Vendedor")
public class VendedorController
{
	private VendedorServiceImpl vendedorService = new VendedorServiceImpl();
	
	private EmpresaServiceImpl empresaSerivce = new EmpresaServiceImpl();
	
	@RequestMapping("/NovoVendedor")
	public String NovoVendedor(Model model)
	{
		try
		{
			Vendedor vendedor = new Vendedor();
			
			HibernateFactory.openSession();
			
			List<Empresa> empresas = empresaSerivce.getEmpresas();		
			
			HibernateFactory.closeSession();
			
			empresas.add(new Empresa (0,""));
			
			model.addAttribute("vendedor",vendedor);		
			
			model.addAttribute("empresas",empresas);
			
			return "NovoVendedor";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "NovoVendedor";
		}

	}
	
	@RequestMapping("/CadastrarVendedor")
	@PostMapping
	public String CadastrarVendedor(@ModelAttribute("vendedor") Vendedor vendedor, HttpServletRequest request )
	{
		try
		{
			HibernateFactory.openSession();
			
			String test = request.getParameter("idempresa");
			
			Empresa empresa = empresaSerivce.getEmpresaPor(Integer.parseInt(request.getParameter("idempresa")));			
			vendedor.setEmpresa(empresa);		
			vendedorService.AdicionarAlterar(vendedor);
			
			HibernateFactory.closeSession();
			
			return"redirect:/Vendedor/Vendedores";		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return"redirect:/Vendedor/Vendedores";		
		}

	}
	
	@RequestMapping("/EditarVendedor")
	public String EditarVendedor(@RequestParam("id") int id,Model model)
	{
		try
		{
			HibernateFactory.openSession();
			
			Vendedor vendedor = vendedorService.getVendedorPor(id);
									
			List<Empresa> empresas = empresaSerivce.getEmpresas();
			
			HibernateFactory.closeSession();
			
			empresas.add(new Empresa (0,""));
			
			model.addAttribute("empresas",empresas);	
			
			model.addAttribute("vendedor",vendedor);
			
			return "NovoVendedor";			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "NovoVendedor";		
		}

	}
	
	@RequestMapping("/ApagarVendedor")
	public String ApagarVendedor(@RequestParam("id") int id)
	{
		try
		{
			HibernateFactory.openSession();
			
			Vendedor vendedor = vendedorService.getVendedorPor(id);
			
			vendedor.setEmpresa(null);		
			
			vendedorService.AdicionarAlterar(vendedor);
			
			HibernateFactory.closeSession();
			
			vendedorService.Remover(vendedor);		
			
			return"redirect:/Vendedor/Vendedores";			
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return"redirect:/Vendedor/Vendedores";	
					
		}

	}
	
	@RequestMapping("/Vendedores")
	public String Vendedores(Model model)
	{
		try
		{
			HibernateFactory.openSession();
			
			List<Vendedor> vendedores = vendedorService.getVendedores();
			
			HibernateFactory.closeSession();
						
			model.addAttribute("vendedores", vendedores);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		
		return "/Vendedores";
	}
}
