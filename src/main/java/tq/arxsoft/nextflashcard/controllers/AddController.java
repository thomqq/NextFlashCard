/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tq.arxsoft.nextflashcard.controllers.models.IdValue;
import tq.arxsoft.nextflashcard.entity.CategoryEntity;
import tq.arxsoft.nextflashcard.entity.PartOfSpeechEntity;
import tq.arxsoft.nextflashcard.logic.LessonManager;

/**
 *
 * @author tkudas
 */
@Controller
public class AddController {

    @Autowired
    LessonManager lessonManager;

    @RequestMapping("add")
    String add(Model model) {
        List< IdValue> categories = new ArrayList<IdValue>();
        prepareCategories(categories);
        model.addAttribute("categories", categories);
        
        List< IdValue> parts = new ArrayList<IdValue>();
        preparePartOfSpeech(parts);
        model.addAttribute("psrt_of_speechies", parts);
        return "add";
    }

    private void prepareCategories(List<IdValue> catList) {
        List<CategoryEntity> categories = lessonManager.getCategories();
        for (CategoryEntity category : categories) {
            catList.add(new IdValue(category.getId(), category.getName()));
        }
    }
    
     private void preparePartOfSpeech(List<IdValue> partList) {
        List<PartOfSpeechEntity> parts = lessonManager.getPartOfSpeech();
         for (PartOfSpeechEntity part : parts) {
            partList.add(new IdValue(part.getId(), part.getName()));
         }
    }
}
