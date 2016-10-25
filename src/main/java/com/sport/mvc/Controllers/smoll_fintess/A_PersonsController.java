package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.Group;
import com.sport.mvc.services.GroupService;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/registerPerson/")
public class A_PersonsController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;




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

    //method for jump register page FITNESS CENTRE =)
    @RequestMapping(value = "/registerFitnessCenter")
    public String showRegisterFitnessCentre(Model model){
        return "register_pages/registerFitnessCenter";
    }
    //method for jump register page guest =)
    @RequestMapping(value = "/registerGuest")
    public String showRegisterGuest(Model model){
        return "register_pages/registerGuest";
    }
    //method for jump register page SportsSection =)
    @RequestMapping(value = "/registerSportsSection")
    public String showRegisterSportSection(Model model){
        return "register_pages/registerSportsSection";
    }
    //method for jump register page Trainer =)
    @RequestMapping(value = "/registerTrainer")
    public String showRegisterTrainer(Model model){
        return "register_pages/registerTrainer";
    }



    @RequestMapping(value = "/showFirstWorkPage",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView workPage(){
        //add atribute to group
        List<Group> groupList = groupService.getAll();
//        groupList.add("DeleteOp");
//        groupList.add("CreateOp");
//        groupList.add("CategotyOp");

        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAll();

        modelAndView.addObject("students", students);
        modelAndView.setViewName("A_small_fitness_first_work_Page");
            modelAndView.addObject("students", students);
            modelAndView.addObject("groupList", groupList);
            modelAndView.setViewName("A_small_fitness_first_work_Page");
        return modelAndView;
    }



    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        //format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
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

 //   sorts students by age(after 16, befor 16 and select all student
    @RequestMapping("/sort")
    public ModelAndView sortMethod(Model model, @RequestParam("option") String option) {
        List<Student> students =new ArrayList<>();
        //new modelAndView for return to jsp listStudent with the selected parameters
        ModelAndView modelAndView = new ModelAndView();
        if (option.equals("ageAfterSixteen")) {

             students = studentService.getStudentAgeAfterSixteen();
        }
       else if (option.equals("ageBeforeSixteen")){
           students = studentService.getStudentAgeBeforSixteen();

        }

        else  if(option.equals("getUnknownStudent")){
            students =studentService.getStudentByOnlyUnknownStudent();
        }

        else if(option.equals("allStudent")){
            students = studentService.getAll();

        }

            modelAndView.addObject("students", students);
            modelAndView.setViewName("A_small_fitness_first_work_Page");
            return modelAndView;


    }

    @RequestMapping("/find")
    public ModelAndView findStudent(@RequestParam(value = "data", required = false) String data,
                                    @RequestParam(value = "option", required = false) String option) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAll();
        Set<Student> particularCollision = new LinkedHashSet<Student>();
        List<Student> fullCollision = new ArrayList<Student>();
        Set<Student> receivedStudents = new LinkedHashSet<Student>();
        data = data.toLowerCase();
        if (option.equals("name")) {
                for (int i = 0; i<students.size(); i++) {
                    //to prevent CAPS symbols
                   String names =  students.get(i).getName().toLowerCase();
                    if (names.equals(data)){
                        //add full collision
                       fullCollision.add(students.get(i));
                    }
                    if (names.contains(data)) {
                        //add particular coincidence
                        particularCollision.add(students.get(i));
                }

            }

        }
        //do the steps above in the surname and email parts
        else if (option.equals("surname")) {
            for (int i = 0; i<students.size(); i++) {
                String names =  students.get(i).getSurname().toLowerCase();
                if (names.equals(data)){
                    System.out.println(students.get(i));
                    fullCollision.add(students.get(i));
                }

                    if (names.contains(data)) {
                        particularCollision.add(students.get(i));
                }

            }
        }
        else if (option.equals("email")) {
            for (int i = 0; i<students.size(); i++) {
                String names =  students.get(i).getEmail().toLowerCase();
                if (names.equals(data)){
                    fullCollision.add(students.get(i));
                }
                    if (names.contains(data)) {
                        particularCollision.add(students.get(i));
                }

            }
        }
        else if (option.equals("phone")) {
            for (int i = 0; i<students.size(); i++) {
                if (students.get(i).getPhone().equalsIgnoreCase(data)) {
                    particularCollision.add(students.get(i));
                }
            }
        }
        //remove from particular collision data which was in fullcollision
        particularCollision.removeAll(fullCollision);
        //to print firs full collision add first fullcollision to the LinkedHashSet value
        receivedStudents.addAll(fullCollision);
        //add the other results
        receivedStudents.addAll(particularCollision);
        modelAndView.addObject("students", receivedStudents);
        modelAndView.setViewName("A_small_fitness_first_work_Page");
        return modelAndView;
    }


}
