package br.com.adriano.springmvc_hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import r.com.adriano.springmvc_hibernate.service.EmpresaServiceImpl;



@Entity
@Table(name = "vendedor" )
public class Vendedor
{

	public Vendedor(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendedor_id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	//Cascade sem o delete para nao remover o registro vendedor que está ligado na empresa
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa;

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
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Empresa getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(Empresa empresa)
	{
		this.empresa = empresa;
	}
	
	
}
