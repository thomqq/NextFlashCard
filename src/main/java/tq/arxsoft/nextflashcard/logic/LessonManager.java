/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import java.util.Collection;
import java.util.List;
import tq.arxsoft.nextflashcard.entity.CategoryEntity;
import tq.arxsoft.nextflashcard.entity.FlashCardEntity;
import tq.arxsoft.nextflashcard.entity.PartOfSpeechEntity;

/**
 *
 * @author tkudas
 */
public interface LessonManager {

    FlashCardEntity getNextFlasCard();

    default public void correctAnswer() {
    }

    default public void incorrectAnswer() {
    }

    default public String getTitle() {
        return "";
    }

    default List<CategoryEntity> getCategories() {
        return null;
    }

    default List<PartOfSpeechEntity> getPartOfSpeech() {
        return null;
    }

}
