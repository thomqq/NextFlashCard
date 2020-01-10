/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import org.springframework.stereotype.Component;
import tq.arxsoft.nextflashcard.entity.FlashCardEntity;

/**
 *
 * @author tkudas
 */

@Component
public class LessonManagerFake implements LessonManager{

    @Override
    public FlashCardEntity getNextFlasCard() {
        return new FlashCardEntity(1, "dom", "house", 0, 0);
    }
    
}
