package r.com.adriano.springmvc_hibernate.service;

import java.util.List;

import javax.persistence.Query;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Vendedor;

public class VendedorServiceImpl implements VendedorService
{

	@Override
	public void AdicionarAlterar(Vendedor vendedor)
	{
		try
		{
			HibernateFactory.session.saveOrUpdate(vendedor);

			HibernateFactory.session.getTransaction().commit();


		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}
		
	}

	@Override
	public void Remover(Vendedor vendedor)
	{
		try
		{
		
			HibernateFactory.openSession();
			
			HibernateFactory.session.delete(vendedor);

			HibernateFactory.session.getTransaction().commit();
			
			HibernateFactory.closeSession();
			

		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}
		
	}

	@Override
	public List<Vendedor> getVendedores()
	{
		try
		{

			Query queryVendedores = HibernateFactory.session.createQuery("from Vendedor order by Nome");
	
			List<Vendedor> vendedores = queryVendedores.getResultList();
			
			for(Vendedor vendedor : vendedores)
				vendedor.getEmpresa();

	
			return vendedores;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}
	}

	@Override
	public Vendedor getVendedorPor(int id)
	{
		try
		{

			Vendedor vendedor = HibernateFactory.session.get(Vendedor.class, id);


			return vendedor;
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}
	}

}
