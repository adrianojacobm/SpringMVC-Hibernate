package br.com.adriano.springmvc_hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import r.com.adriano.springmvc_hibernate.service.EmpresaServiceImpl;
import r.com.adriano.springmvc_hibernate.service.ProdutoServiceImpl;


@Entity
@Table(name = "empresa" )
public class Empresa
{

	public Empresa() {}
	
	public Empresa(int id, String nome) {this.id = id; this.nome_empresa = nome;}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empresa_id")
	private int id;
	
	@Column(name = "nome_empresa")
	private String nome_empresa;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	//fetch = FetchType.EAGER trará todos os vendedores assim que buscar uma empresa por ser uma relação bi-direcional
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Vendedor> vendedores = new ArrayList();
	
	@ManyToMany( mappedBy = "empresas")
	private List<Produto> produtos = new ArrayList();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome_empresa;
	}

	public void setNome(String nome)
	{
		this.nome_empresa = nome;
	}

	public String getEndereco()
	{
		return endereco;
	}

	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public List<Vendedor> getVendedores()
	{
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores)
	{
		this.vendedores = vendedores;
	}
	
	public void adicionarVendedor(Vendedor vendedor)
	{
	
		vendedores.add(vendedor);
		vendedor.setEmpresa(this);
		
	}
	
	public void setProdutos(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos()
	{
				
		return this.produtos;
	}
	
	public void adicionarProduto(Produto produto)
	{		
		
		this.produtos.add(produto);
		
	}
	
	public void PreencherProdutos()
	{
		EmpresaServiceImpl empresaService = new EmpresaServiceImpl();
		this.produtos = empresaService.getProdutosPorEmpresa(this);
	}
	
	
}
