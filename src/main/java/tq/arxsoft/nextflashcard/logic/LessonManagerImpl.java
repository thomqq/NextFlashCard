/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import tq.arxsoft.nextflashcard.entity.FlashCardEntity;

/**
 *
 * @author tkudas
 */
@Component
//@Scope(
//value=WebApplicationContext.SCOPE_SESSION,
//proxyMode=ScopedProxyMode.INTERFACES)
@Primary
@Transactional
public class LessonManagerImpl implements LessonManager {

    @PersistenceUnit
    EntityManagerFactory emf;

    private int flashCardId = 1;

    @Override
    public FlashCardEntity getNextFlasCard() {
        return emf.createEntityManager().find(FlashCardEntity.class, flashCardId);
    }

    @Override
    @Transactional
    public void correctAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCardEntity currentFlashCard = entityManager.find(FlashCardEntity.class, flashCardId);
        currentFlashCard.setCorrect(currentFlashCard.getCorrect() + 1);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional
    public void incorrectAnswer() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        FlashCardEntity currentFlashCard = entityManager.find(FlashCardEntity.class, 1);
        currentFlashCard.setIncorrect(currentFlashCard.getIncorrect() + 1);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

}
