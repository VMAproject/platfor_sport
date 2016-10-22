package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.User;
import com.sport.mvc.socialAdvertisement.SendMailService;

import com.sport.mvc.models.Student;
import com.sport.mvc.services.PhoneService;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/registerPerson/")
public class A_PersonsController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;


    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;

    @Autowired
    @Qualifier("mail")
    private SendMailService sendMailService;




    @RequestMapping(value = "/general_registration_form")
    public String showForm(Model model){

        //   RegisterPerson theRegisterPerson= new RegisterPerson();
        //   model.addAttribute("registerPersonDate", theRegisterPerson);
        return "general_registration_formRegistry";

    }

    @RequestMapping(value = "/showFirstWorkPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView workPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAll();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("A_small_fitness_first_work_Page");

        return modelAndView;
    }



    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        //format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "A_small_fitness_add_student";
    }


    @PostMapping("/saveStudent")
    public String saveCustomer(@ModelAttribute("student") Student theStudent) {
        studentService.addStudent(theStudent);
        return "redirect:/registerPerson/showFormForAdd";
    }

    @RequestMapping("/delete")
    public String deleteListOfUsers(@RequestParam(value = "deletee", required = false) String deletee,
                                    @RequestParam(value = "send_email", required = false) String sendEmail, Model model,
                                    @RequestParam(value = "case", required = false) List <Long> ids,
                                    RedirectAttributes ra) {


        if(deletee!=null){
            if (ids!=null)

                for (int i =0; i < ids.size();i++) {
                    System.out.println("in method A_controller del " + ids );
                    studentService.deleteListOfStudents(ids.get(i));
                }
        }
        else if(sendEmail!=null){
            //redirect our ids to the send message page
            ra.addFlashAttribute("id", ids);
            return "redirect:/registerPerson/showMailForm";


        }

        return "redirect:/registerPerson/showFirstWorkPage";
    }

    @PostMapping("/saveStudentAfterUpdate")
    public String saveCustomerAfterUpdate(@ModelAttribute("student") Student theStudent) {
        studentService.updateStudent(theStudent);
        return "redirect:/registerPerson/showFirstWorkPage";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel) {

        //   logger.info("showing form for update");
        System.out.println(theId);
        // get customer from database
        Student theStudent = studentService.getStudent(theId);
        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        return "A_small_fitness_update_student";
    }
    //create empty array list in order to fill it in the showMailForm method
    List<String> studenEmail = new ArrayList<String>();
    @PostMapping("/sendMail")
    public String sendMail(HttpServletRequest request){
        //get the topic and body of the message
        String body = request.getParameter("body");
        String topic = request.getParameter("topic");
        for (int i=0; i<studenEmail.size(); i++) {
            if (studenEmail.get(i)!=null || !studenEmail.get(i).equals(""));
            sendMailService.sendMailTo(studenEmail.get(i), topic, body);

        }
        return "redirect:/registerPerson/showFirstWorkPage";
//
    }


    @RequestMapping("/showMailForm")
    public String showMailForm(Model theModel, @ModelAttribute("id") List<Long> ids){
    //get our ids and get user name, and email
        //add received emails to the arrauList
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i<ids.size(); i++) {
            students.add(studentService.getStudent(ids.get(i)));
            String email = students.get(i).getEmail();
            studenEmail.add(email);
        }
        theModel.addAttribute("id", ids);
        theModel.addAttribute("students", students);
        return "A_send_mail_form";
        //
    }

    //sorts students by age and who get only phone number
    @RequestMapping("/sort")
    public String sortMethod(Model model, @RequestParam("option") String option) {
        List<Student> students = studentService.getAll();
        List<Student> studentsOnlyWithPhoneNumber = null;
        if (option.equals("age")) {
            Collections.sort(students, new Comparator<Student>(){
                public int compare(Student s1, Student s2) {
                    //if user has birthday
                    if (s1.getBirthday()!=null && s2.getBirthday()!=null)
                    return s1.getBirthday().compareTo(s2.getBirthday());
                    else
                    //else compare by name
                    if (s1.getName()!=null && s2.getName()!=null)
                        return s1.getName().compareToIgnoreCase(s1.getName());
                    return 0;
                }
            });
        }
        else if (option.equals("number")) {
            for (int i = 0; i<students.size(); i++) {
                if (students.get(i).getName()==null && students.get(i).getEmail()==null) {
                    studentsOnlyWithPhoneNumber.add(students.get(i));
                }
            }
        }

        //here's a problem
        //how to send different students to one page ????
        model.addAttribute("students", students);
        model.addAttribute("studenst", studentsOnlyWithPhoneNumber);
        return "redirect:/registerPerson/showFirstWorkPage";
    }


}
