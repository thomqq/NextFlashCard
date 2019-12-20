/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import tq.arxsoft.nextflashcard.entity.FlashCardEntity;

/**
 *
 * @author tkudas
 */
public interface LessonManager {

    FlashCardEntity getNextFlasCard();

    default public void correctAnswer() {}

    default public void incorrectAnswer() {}
}
