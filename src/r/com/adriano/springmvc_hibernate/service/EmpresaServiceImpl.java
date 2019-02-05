package r.com.adriano.springmvc_hibernate.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.dao.HibernateUtil;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Produto;


public class EmpresaServiceImpl implements EmpresaService
{

	@Override
	public void AdicionarAlterar(Empresa empresa)
	{
		try
		{	
			HibernateFactory.openSession();

			HibernateFactory.session.saveOrUpdate(empresa);

			HibernateFactory.session.getTransaction().commit();
			
			HibernateFactory.closeSession();


		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}

	}

	@Override
	public void Remover(Empresa empresa)
	{
		try
		{
			HibernateFactory.openSession();

			HibernateFactory.session.delete(empresa);

			HibernateFactory.session.getTransaction().commit();
			
			HibernateFactory.closeSession();


		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}

	}

	@Override
	public List<Empresa> getEmpresas()
	{
		try
		{
			HibernateFactory.openSession();
			
			Query query = HibernateFactory.session.createQuery("from Empresa order by Nome_Empresa");
	
			List<Empresa> empresas = query.getResultList();
			
			HibernateFactory.closeSession();
	
			return empresas;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}
	}

	@Override
	public Empresa getEmpresaPor(int id)
	{
		try
		{
			HibernateFactory.openSession();
			
			Empresa empresa = HibernateFactory.session.get(Empresa.class, id);
			
			HibernateFactory.closeSession();


			return empresa;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}
	}
	
	public List<Produto> getProdutosPorEmpresa(Empresa empresa)
	{
		HibernateFactory.openSession();
		
		Query query = HibernateFactory.session.createQuery("from Produto T0 inner join fetch T0.empresas T1"
				+ " where T1.id = "+empresa.getId());
	
		List<Produto> produtos = query.getResultList();
		
		HibernateFactory.closeSession();
					
		return produtos;
	}
	


}
