package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.entity.Customer;
import com.sport.mvc.repozitoriy.CustomerDAO;
import com.sport.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@Controller
@RequestMapping("/registerPerson/")
public class A_PersonsController {


    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerService customerService;

    private Logger logger = Logger.getLogger(String.valueOf(getClass()));

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        logger.info("showing form for add");

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        logger.info("saving customer: " + theCustomer);

        customerService.saveCustomer(theCustomer);

        return "redirect:/registerPerson//showFirstWorkPage";

    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

        logger.info("showing form for update");

        // get customer from database
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        logger.info("deleting customer id: " + theId);

        // delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/registerPerson//showFirstWorkPage";
    }
}
