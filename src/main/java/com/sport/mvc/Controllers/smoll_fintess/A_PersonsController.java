package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.entity.Customer;
import com.sport.mvc.repozitoriy.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/registerPerson/")
public class A_PersonsController {


    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/general_registration_form")
    public String showForm(Model model){

     //   RegisterPerson theRegisterPerson= new RegisterPerson();

     //   model.addAttribute("registerPersonDate", theRegisterPerson);

        return "general_registration_formRegistry";

    }

    @RequestMapping("/showFirstWorkPage")
//    public String showDataForm(@ModelAttribute("registerPersonDate") RegisterPerson registerPerson){
    public String showFirstWorkPage(Model theModel){

      //  System.out.println(registerPerson.getFirstName());
// get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "A_small_fitness_first_work_Page";
    }
}
