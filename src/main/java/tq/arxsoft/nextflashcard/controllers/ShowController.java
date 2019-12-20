/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tq.arxsoft.nextflashcard.entity.FlashCardEntity;
import tq.arxsoft.nextflashcard.logic.LessonManager;

/**
 *
 * @author tkudas
 */
@Controller
public class ShowController {
    
    @Autowired
    LessonManager lessonManager;

    @RequestMapping
    public String show(Model model) {
        
        FlashCardEntity flashCard = lessonManager.getNextFlasCard();
        
        model.addAttribute("flash_card", flashCard);
        return "show";
    }
    
    @RequestMapping("/correct")
    public String correct() {
        lessonManager.correctAnswer();
        return "redirect:/logic/show";
    }
    
    @RequestMapping("/incorrect")
    public String incorrect() {
        lessonManager.incorrectAnswer();
        return "redirect:/logic/show";
    }

}
