package com.edith.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils
{
	static EntityManagerFactory factory;
	static
	{
		factory = Persistence.createEntityManagerFactory("mysql");
	}
	
	// 返回一个连接
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
}
