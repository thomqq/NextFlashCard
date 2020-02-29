/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tkudas
 */
@Controller
public class LoginController {

//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
//    public ModelAndView welcomePage() {
//        /*
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
//        authentication.getAuthorities().iterator().next().getAuthority();
//
//        Set<String> roles = authentication.getAuthorities().stream()
//                .map(r -> r.getAuthority()).collect(Collectors.toSet());
//         */
//        ModelAndView model = new ModelAndView();
//        model.setViewName("welcomePage");
//        return model;
//    }

//    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
//    public ModelAndView homePage() {
//        ModelAndView model = new ModelAndView();
//        model.setViewName("show");
//        return model;
//    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }
}
