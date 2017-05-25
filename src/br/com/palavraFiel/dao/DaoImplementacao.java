package br.com.palavraFiel.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.palavraFiel.hibernate.HibernateUtil;

@Transactional(noRollbackFor = Exception.class)
@Service
public abstract class DaoImplementacao<T> implements DaoInterface<T> {
	
	private Class<T> persistenceClass;
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public DaoImplementacao(Class<T> persistenceClass ){
		super();
		this.persistenceClass = persistenceClass;
	}
	
	@Override
	public void salvar(T objeto) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(objeto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deletar(T objeto) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(objeto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void atualizar(T objeto) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(objeto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void salvarOuAtualizar(T objeto) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(objeto);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public T merge(T objeto) throws Exception {
		// TODO Auto-generated method stub
		T t = (T) sessionFactory.getCurrentSession().merge(objeto);
		sessionFactory.getCurrentSession().flush();
		return t;
	}
	
	@Override
	public List<T> lista() throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(persistenceClass).list();
	}

}
