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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;

@Entity
@Table(name = "produto" )
public class Produto
{
	
	public Produto(){}
	
	public Produto(String nome,double preco)
	{
		this.nome = nome;
		this.preco = preco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int produto_id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco")
	private double preco;
		
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
	@JoinTable(name = "empresa_produto", joinColumns = { 
			@JoinColumn(name = "produto_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "empresa_id") })
	List<Empresa> empresas = new ArrayList();
	
	public void setId(int id)
	{
		this.produto_id = id;
	}

	public int getId()
	{
		return produto_id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(double preco)
	{
		this.preco = preco;
	}
	
	public void setEmpresas(List<Empresa> empresas)
	{
		this.empresas = empresas;
	}
	
	public List<Empresa> getEmpresas()
	{
		return this.empresas;
	}
	
	public void adicionarEmpresa(Empresa empresa)
	{
		this.empresas.add(empresa);
	}
	
	public boolean VerificaEmpresa(int empresaId)
	{
		
		if(empresas == null)
			return false;
		else
		{
			for(Empresa empresa : empresas)
			{
				if(empresa.getId() == empresaId)
					return true;
			}
			
			return false;
		}
	}
}
