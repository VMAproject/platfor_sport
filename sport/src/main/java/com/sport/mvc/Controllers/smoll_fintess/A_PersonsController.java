package com.sport.mvc.Controllers.smoll_fintess;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registerPerson/")
public class A_PersonsController {


    @RequestMapping("/general_registration_form")
    public String showForm(Model model){

     //   RegisterPerson theRegisterPerson= new RegisterPerson();

     //   model.addAttribute("registerPersonDate", theRegisterPerson);

        return "general_registration_formRegistry";

    }

    @RequestMapping("/showFirstWorkPage")
//    public String showDataForm(@ModelAttribute("registerPersonDate") RegisterPerson registerPerson){
    public String showFirstWorkPage(){

      //  System.out.println(registerPerson.getFirstName());

        return "A_small_fitness_first_work_Page";
    }
}
