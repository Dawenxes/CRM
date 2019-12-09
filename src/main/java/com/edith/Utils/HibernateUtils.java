package com.edith.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils 
{
		static Configuration configuration =null;
		static SessionFactory sessionFactory = null;
		static
		{
			//创建服务注册对象
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			//创建会话工厂对象
			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			//会话对象

		}
		
		public static Session openSession()
		{
			return sessionFactory.getCurrentSession();
		}
}
