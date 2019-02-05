package r.com.adriano.springmvc_hibernate.service;

import java.util.List;

import javax.persistence.Query;
import br.com.adriano.springmvc_hibernate.dao.HibernateFactory;
import br.com.adriano.springmvc_hibernate.entities.Empresa;
import br.com.adriano.springmvc_hibernate.entities.Produto;

public class ProdutoServiceImpl implements ProdutoService
{

	public ProdutoServiceImpl()
	{

	}
	
	@Override
	public List<Produto> getProdutos()
	{

		try
		{
			HibernateFactory.openSession();

			Query q = HibernateFactory.session.createQuery("from Produto order by Nome");

			List<Produto> produtos = q.getResultList();
			
			HibernateFactory.closeSession();


			return produtos;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}

	}

	@Override
	public void AdicionarAlterar(Produto produto)
	{
		try
		{

			HibernateFactory.openSession();
			
			HibernateFactory.session.saveOrUpdate(produto);

			HibernateFactory.session.getTransaction().commit();
			
			HibernateFactory.closeSession();


		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}

	}

	@Override
	public void Remover(Produto produto)
	{
		try
		{
			HibernateFactory.openSession();

			HibernateFactory.session.delete(produto);

			HibernateFactory.session.getTransaction().commit();
			
			HibernateFactory.closeSession();


		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}

	}


	@Override
	public Produto getProdutoPor(int id)
	{
		try
		{
			HibernateFactory.openSession();

			Produto produto = HibernateFactory.session.get(Produto.class, id);
			
			
			
			HibernateFactory.closeSession();


			return produto;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
			return null;
		}

	}
	
	public void setEmpresa(int produtoId, int empresaId)
	{
		try
		{
			HibernateFactory.openSession();
			
			Produto produto = HibernateFactory.session.get(Produto.class, produtoId);
			Empresa empresa = HibernateFactory.session.get(Empresa.class, empresaId);			
			produto.adicionarEmpresa(empresa);
			HibernateFactory.session.merge(produto);
			HibernateFactory.session.getTransaction().commit();
			HibernateFactory.closeSession();
			
		}		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			HibernateFactory.session.close();
		}
	}
	
	public void setEmpresasPor(Produto produto)
	{

			HibernateFactory.openSession();
			
			Query query = HibernateFactory.session.createQuery("from Empresa T0 inner join fetch T0.produtos T1"
					+ " where T1.produto_id = "+produto.getId());
		
			List<Empresa> empresas = query.getResultList();
			
			HibernateFactory.closeSession();
						
			produto.setEmpresas(empresas);

	}
	

}
