/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tq.arxsoft.nextflashcard.entity.FlashCardEntity;

/**
 *
 * @author tkudas
 */

@Component
@Primary
@Transactional
public class LessonManagerImpl implements LessonManager{
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public FlashCardEntity getNextFlasCard() {
        return entityManager.find(FlashCardEntity.class, 1);
    }
    
}
