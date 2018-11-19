package com.unitbv.lab1.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class GenericDAO<T> {

	private Class<T> type;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public GenericDAO(String persistenceUnitName, Class<T> type) {
		this.type = type;
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	public void close() {
		entityManagerFactory.close();
	}

	public T createOrUpdate(T entity) {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();
			return null;
		} finally {
			entityManager.close();
		}
	}

	public T findById(int id) {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager.find(type, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}

	public T update(T entity) {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();
			return null;
		} finally {
			entityManager.close();
		}
	}

	public void delete(T entity) {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			/* entity = entityManager.find(type, entity.Id); */
			entity = entityManager.merge(entity);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

	public void deleteAll() {
		try {
			for (T b : readAll()) {
				delete(b);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<T> readAll() {
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String className = type.getSimpleName().split(",")[type.getSimpleName().split(",").length - 1];
			Query query = entityManager.createQuery("SELECT t from " + className + " t");
			@SuppressWarnings("unchecked")//TODO see how to fix this
			List<T> result = query.getResultList();
			return result;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		} finally {
			entityManager.close();
		}
	}
}