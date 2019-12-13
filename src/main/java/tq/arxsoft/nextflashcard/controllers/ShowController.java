/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tkudas
 */
@Controller
public class ShowController {

    @RequestMapping("show")
    public String show(Model model) {
        model.addAttribute("question", "drzwi");
        model.addAttribute("answer", "door");
        model.addAttribute("showAnswer", "true");
        return "show";
    }

//    @RequestMapping("zosia")
//    public String show1() {
//        return "zosia";
//    }
}
