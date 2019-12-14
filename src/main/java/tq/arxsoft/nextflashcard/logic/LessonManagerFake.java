/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tq.arxsoft.nextflashcard.model.FlashCard;

/**
 *
 * @author tkudas
 */

@Component
public class LessonManagerFake implements LessonManager{

    @Override
    public FlashCard getNextFlasCard() {
        return new FlashCard("dom", "house");
    }
    
}
