package com.xworkz.finalProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.finalProject.entity.SignUpEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SignUpRepoImpl implements SignUpRepo {

	@Autowired
	private EntityManagerFactory entitymanager;

	@Override
	public boolean save(SignUpEntity entity) {
		log.info("Running save method in repoImple");
		EntityManager manager = this.entitymanager.createEntityManager();
		
			EntityTransaction trancsaction = manager.getTransaction();
			trancsaction.begin();
			manager.persist(entity);
			trancsaction.commit();
			return true;
		
	}

	@Override
	public List<SignUpEntity> findAll() {
		log.info("Running findAll in repoImpl");
		EntityManager manager = this.entitymanager.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findall");
			List<SignUpEntity> list = query.getResultList();
			log.info("total size in repo" + list.size());
			return list;
		} finally {
			manager.close();
		}

	}

	@Override
	public Long findByUser(String userId) {
		log.info("Running findByUser in repoImpl");
		EntityManager entityManager = this.entitymanager.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("findByUser");
			query.setParameter("userName", userId);
			Object object = query.getSingleResult();
			Long counts = (Long) object;
			System.out.println(counts);
			return counts;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Long findByEmaiId(String email) {
		EntityManager manager = this.entitymanager.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByEmaiId");
			query.setParameter("mail", email);
			Object obj = query.getSingleResult();
			Long Count = (Long) obj;
			System.out.println(Count);
			return Count;
		} finally {
			manager.close();
		}
	}

	@Override
	public Long findByMobileNo(Long mobile) {

		EntityManager manager = this.entitymanager.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByMobileNo");
			query.setParameter("mobileNo", mobile);
			Object obj = query.getSingleResult();
			Long value = (Long) obj;
			System.out.println(value);
			return value;
		} finally {
			manager.close();
		}

	}
	
	@Override
	public SignUpEntity signIn(String userId) {
		log.info("Running signIn in repo");
		EntityManager  manager=	this.entitymanager.createEntityManager();
		try {
	Query query=manager.createNamedQuery("FindByUserId");
	query.setParameter("user", userId);
Object obj=	query.getSingleResult();
SignUpEntity value1=(SignUpEntity) obj;
System.out.println(value1);
return value1;

		}
		finally {
			manager.close();
		}
	}

	@Override
	public boolean loginCount(String userId, int count) {
log.info("login counts"+count);
EntityManager  manager=	this.entitymanager.createEntityManager();
try{
	EntityTransaction trans=manager.getTransaction();
	trans.begin();
	Query query=manager.createNamedQuery("loginCount");
	query.setParameter("u", userId);
	query.setParameter("counts", count);
	query.executeUpdate();
	trans.commit();
	return true;
}
	finally {
		manager.close();
	}	

	}
	
	
	
	
	
	
	
	
	/*
	 * @Override public SignUpEntity resetPassword(String email) { EntityManager
	 * manager= this.entitymanager.createEntityManager(); try { Query
	 * query=manager.createNamedQuery("reset"); query.setParameter("resetEmail",
	 * email); Object obj=query.getSingleResult(); SignUpEntity
	 * value2=(SignUpEntity)obj; log.info(""+value2); return value2; } finally {
	 * manager.close(); } }
	 */
	
	
	
	
	
	
	
	
	
	

}
