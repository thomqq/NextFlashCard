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
import tq.arxsoft.nextflashcard.logic.LessonManager;
import tq.arxsoft.nextflashcard.model.FlashCard;

/**
 *
 * @author tkudas
 */
@Controller
public class ShowController {
    
    @Autowired
    LessonManager lessonManager;

    @RequestMapping("show")
    public String show(Model model) {
        
        FlashCard flashCard = lessonManager.getNextFlasCard();
        
        model.addAttribute("flash_card", flashCard);
        model.addAttribute("showAnswer", "true");
        return "show";
    }

}
