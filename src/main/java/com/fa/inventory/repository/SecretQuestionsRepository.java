/**
 * 
 */
package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.SecretQuestionsEntity;

/**
 * @author Suresh
 *
 */
public interface SecretQuestionsRepository extends JpaRepository<SecretQuestionsEntity	, Long>{	
	
	SecretQuestionsEntity findBySecretQuestion(String string);		

}
