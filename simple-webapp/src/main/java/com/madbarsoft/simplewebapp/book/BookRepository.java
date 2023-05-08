package com.madbarsoft.simplewebapp.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookRepository {

	@Autowired
	private EntityManager entityManager;
	
	
	public String findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = builder.createQuery( BookEntity.class );
        Root<BookEntity> root = criteria.from(BookEntity.class);
        criteria.select(root).where(
                builder.equal(root.get("id"), id)
        );
        try{
        	return entityManager.createQuery(criteria).getSingleResult().toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
        
    }
	
	public BookEntity findByIdObj(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = builder.createQuery( BookEntity.class );
        Root<BookEntity> root = criteria.from(BookEntity.class);
        criteria.select(root).where(
                builder.equal(root.get("id"), id)
        );
        try{
        	return entityManager.createQuery(criteria).getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
	
	
	public String findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = builder.createQuery( BookEntity.class );
        Root<BookEntity> root = criteria.from(BookEntity.class);
        criteria.select(root).where(
                builder.equal(root.get("name"), name)
        );
        try{
            return entityManager.createQuery(criteria).getSingleResult().toString();
        }catch (Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
	

    public List<BookEntity> list() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteria = builder.createQuery( BookEntity.class );
        Root<BookEntity> root = criteria.from(BookEntity.class);
        return entityManager.createQuery(criteria).getResultList();
    }
   

    public Boolean save(BookEntity obj) {
        try{
            entityManager.persist(obj);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean update(BookEntity obj){
        try{
            entityManager.merge(obj);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean delete(BookEntity obj) {
        try{
            entityManager.remove(obj);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
