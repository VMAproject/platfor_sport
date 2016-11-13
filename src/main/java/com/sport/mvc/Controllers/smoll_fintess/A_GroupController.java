package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.*;
import com.sport.mvc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;
import java.util.*;


@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @Autowired
    @Qualifier("priceService")
    private PriceService priceService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @Autowired
    @Qualifier("categoryGroupService")
    private CategoryGroupService categoryService;


    //variable for taking the group id, when some group will by in use.
    private Long idGroup;

    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView();

        //create list student,category of group and group for add data to the jsp page
        List<CategoryGroup> categoryGroupList = new ArrayList<>();
        List<Group> groupsList = new ArrayList<>();
        List<Student> studentsListInGroup = new ArrayList<>();

        for (Student s : studentService.getAll()) {
//check, if user has this student, add to student list
            if (s.getUser().getId() != null && s.getUser().getId() == getCurrentUser().getId()) {
//check in which og group the students
                if (s.getGroups().iterator().hasNext() && s.getGroups().iterator().next().getId() == idGroup) {

                    studentsListInGroup.add(s);
                }
            }


        }

        for (Group g : groupService.getAll()) {
            if (g.getUser().getId() != null && g.getUser().getId() == getCurrentUser().getId()) {
                groupsList.add(g);
            }
        }


        for (CategoryGroup g : categoryService.getAll()) {
            if (g.getUser().getId() != null && g.getUser().getId() == getCurrentUser().getId()) {
                categoryGroupList.add(g);
            }
        }

        // show student in his group if group has more then 0 student

        if (!studentsListInGroup.isEmpty()) {
            modelAndView.addObject("students", studentsListInGroup);
        }
        // show group his group if group has more then 0 student
        if (!groupsList.isEmpty()) {
            modelAndView.addObject("groupsList", groupsList);
        }

        // show categoty in his group if group has more then 0 student
        if (!categoryGroupList.isEmpty()) {
            modelAndView.addObject("categoryList", categoryGroupList);
        }

        Group chooseGroup = groupService.getGroup(idGroup);
            modelAndView.addObject("chooseGroup", chooseGroup);
            System.out.println(chooseGroup.getName());

        List<Price> priceList = new ArrayList<Price>();
        for(Price p: priceService.getAll() ){
            if( p.getUser().getId()!=null && p.getUser().getId()==getCurrentUser().getId() &&
                    p.getGroups().getId()!=null && p.getGroups().getId()==idGroup ){
                priceList.add(p);

            }
        }
        for(Price p: priceList){
            System.out.println(p.getPriceSingle()+" price to jsp");
        }
        if(!priceList.isEmpty()){
            modelAndView.addObject("priceList",priceList);
        }

        for (int i = 0; i<studentsListInGroup.size(); i++) {

        }
        modelAndView.addObject("countOfRecords", studentsListInGroup.size());
        //add to page model list of day in current month from method List<String> ListOfDayInMonth()
        modelAndView.addObject("listOfMonth", ListOfDayInMonth());
        modelAndView.addObject("currentUser", getCurrentUser());
        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;
    }


    @RequestMapping(value = "/AddGroupToInstructorsForm", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FormForAddInstructors() {
        // create model attribute to bind form data
        Group group = new Group();
        List<CategoryGroup> categoryGroupList = new ArrayList<>();

        for (CategoryGroup g : categoryService.getAll()) {
            if (g.getUser().getId() != null && g.getUser().getId() == getCurrentUser().getId()) {
                categoryGroupList.add(g);
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        if (!categoryGroupList.isEmpty()) {
            modelAndView.addObject("categoryList", categoryGroupList);
        }
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/add_form/A_small_fitness_add_group_to_instructors");
        return modelAndView;
    }


    @PostMapping("/saveGroupToTrainers")
    public String saveGroupToTrainers(@ModelAttribute("group") Group group, @RequestParam("choose") String categoryName) {
        //add group to DB
        group.setUser(getCurrentUser());
        if (categoryName.equals("")) {
            groupService.addGroup(group);
        } else {
            for (CategoryGroup category : categoryService.getAll()) {
                if (category.getName().equals(categoryName)) {
                    group.setCategoryGroup(category);
                    groupService.addGroup(group);
                }

            }
        }

        return "redirect:/group/AddGroupToInstructorsForm";
    }

    @RequestMapping(value = "/showFormForAddGroup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FormForAddGroup() {
        // create model attribute to bind form data
        Group group = new Group();
        List<CategoryGroup> categoryGroupList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (CategoryGroup category : categoryGroupList) {
            stringList.add(category.getName());
        }
        ModelAndView modelAndView = new ModelAndView();


        for (CategoryGroup g : categoryService.getAll()) {
            if (g.getUser().getId() != null && g.getUser().getId() == getCurrentUser().getId()) {
                categoryGroupList.add(g);
            }
        }

        if (!categoryGroupList.isEmpty()) {
            modelAndView.addObject("categoryList", categoryGroupList);
        }
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/add_form/A_small_fitness_add_group");
        //  return "A_small_fitness_add_group";
        return modelAndView;
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group, @RequestParam("option") String categoryName) {
        //add group to DB
        group.setUser(getCurrentUser()); // add user to group&???
        group.setMain(true);
        if (categoryName.equals("")) {

            groupService.addGroup(group);
        } else {
            for (CategoryGroup category : categoryService.getAll()) {
                if (category.getName().equals(categoryName)) {
                    group.setCategoryGroup(category);

                    groupService.addGroup(group);
                }

            }
        }
        return "redirect:/group/showFormForAddGroup";
    }

    @RequestMapping("/showFormForAddCategory")
    public String showFormForAddCategory(Model theModel) {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();
        theModel.addAttribute("category", category);
        return "a_small_fitness/add_form/A_small_fitness_add_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") CategoryGroup category) {
        //add group to DB
        category.setMain(true);
        category.setUser(getCurrentUser());
        categoryService.addCategoryGroup(category);
        return "redirect:/group/showFormForAddCategory";
    }


    @RequestMapping("/showFormForAddCategoryTrainers")
    public String showFormForAddCategoryTrainers(Model theModel) {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();
        theModel.addAttribute("category", category);
        return "a_small_fitness/add_form/A_small_fitness_add_category_trainers";
    }


    @PostMapping("/saveTrainersCategory")
    public String saveTrainersCategory(@ModelAttribute("category") CategoryGroup category) {
        //add group to DB
        category.setUser(getCurrentUser());
        categoryService.addCategoryGroup(category);
        return "redirect:/group/showFormForAddCategoryTrainers";
    }

    @RequestMapping(value = "/showFormForDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FormForDeleteGroups() {
        // create model attribute to bind form data

        List<Group> groupList = new ArrayList<>();
        for (Group g: groupService.getAll()){
            if(g.getUser().getId()!=null && g.getUser().getId()==getCurrentUser().getId()){
                groupList.add(g);
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        if(!groupList.isEmpty()) {
            modelAndView.addObject("groupList", groupList);
        }

        modelAndView.setViewName("a_small_fitness/delete/A_delete_groups");
        //  return "A_small_fitness_add_group";
        return modelAndView;
    }

    @RequestMapping("/deleteGroups")
    public String deleteGroup(@RequestParam(value = "idGroup", required = false) List<Long> ids) {

        for (int i = 0; i < ids.size(); i++) {
            Group group = groupService.getGroup(ids.get(i));
            if(!group.getStudents().isEmpty()) {
                for (Student s : group.getStudents()) {
                    s.setGroups(null);
                    studentService.addStudent(s);
                }
            }

            if(group.getCategoryGroup()!=null){
                group.setCategoryGroup(null);
                groupService.addGroup(group);

            }

            group.setUser(null);
            groupService.addGroup(group);
            groupService.deleteListOfGroup(ids.get(i));

        }
        return "redirect:/group//ShowGroupPage";
    }


    @RequestMapping(value = "/showFormForUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FormForUpdateGroups() {
        // create model attribute to bind form data
        Group group = new Group();

        List<Group> groupList = new ArrayList<>();
        for (Group g: groupService.getAll()){
            if(g.getUser().getId()!=null && g.getUser().getId() ==getCurrentUser().getId()){
                groupList.add(g);
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        if(!groupList.isEmpty()) {
            modelAndView.addObject("groupList", groupList);
        }
        modelAndView.addObject("group", group);
        modelAndView.setViewName("a_small_fitness/update_form/A_small_fitness_update_groups");

        return modelAndView;
    }


    @PostMapping("/updateGroup")
    public String updateGroup(@ModelAttribute("group") Group group, @RequestParam("option") Long theId) {
        //add group to DB
        System.out.println(group.getName());
        for (Group g : groupService.getAll()) {
            if (g.getId() == theId && groupService.getGroup(theId).isMain() == true) {
                g.setName(group.getName());
                groupService.addGroup(g);
                break;
            }
            if(g.getId()==theId&& groupService.getGroup(theId).isMain()!=true){
                g.setName(group.getName());
                groupService.addGroup(g);
                break;
            }
        }
        return "redirect:/group/showFormForUpdate";
    }


    @RequestMapping(value = "/showFormForUpdateCategory", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FormForUpdateTrainersGroups() {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();

        List<CategoryGroup> categoryGroupList = new ArrayList<>();
        for(CategoryGroup c: categoryService.getAll()){
            if(c.getUser().getId()!=null && c.getUser().getId()==getCurrentUser().getId()){
                categoryGroupList.add(c);
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        if (!categoryGroupList.isEmpty()) {
            modelAndView.addObject("categoryList", categoryGroupList);
        }
        modelAndView.addObject("category", category);
        modelAndView.setViewName("a_small_fitness/update_form/A_small_fitness_update_category");
        //  return "A_small_fitness_add_group";
        return modelAndView;
    }


    @PostMapping("/updateCategory")
    public String updateTrainersGroup(@ModelAttribute("category") CategoryGroup category, @RequestParam("option") Long theId) {
        for (CategoryGroup c : categoryService.getAll()) {
            if(c.getId()==theId && categoryService.getCategoryGroup(theId).isMain()==true) {
                c.setName(category.getName());
                categoryService.addCategoryGroup(c);
            }
            if (c.getId() == theId && categoryService.getCategoryGroup(theId).isMain() != true) {
                c.setName(category.getName());
                categoryService.addCategoryGroup(c);
            }
        }
        return "redirect:/group/showFormForUpdateCategory";
    }




    @RequestMapping("/addStudentToGroupForm")
    public String addStudentToGroup(Model theModel) {
        //create new student for add form
        Student theStudent = new Student();
        //transfer student to "A_add_to_group_Student" form
        theModel.addAttribute("student", theStudent);
        return "a_small_fitness/add_form/A_add_to_group_Student";
    }


    @RequestMapping("saveStudentToGroup")
    public String saveStudentToGroup(@ModelAttribute("student") Student theStudent, Model model) {
        Set<Group> groupSet = new HashSet<>();
        if (theStudent.getName().equals("") && theStudent.getPhone().equals("") && theStudent.getEmail().equals("")
                 && theStudent.getSurname().equals("")) {
            model.addAttribute("nullFields", "Add at least one field");
            return "a_small_fitness/add_form/A_add_to_group_Student";
        }
        groupSet.add(groupService.getGroup(idGroup));
        theStudent.setUser(getCurrentUser());
        theStudent.setGroups(groupSet);
        studentService.addStudent(theStudent);
        return "redirect:/group/addStudentToGroupForm";
    }

    @RequestMapping("/takeIdGroup")
    public String TakeIdGroup(@RequestParam("groupId") long theId) {
        //take id group, where we now, and write it in to global variable->idGroup
        idGroup = theId;
        //return to showGroup page for fow all data on the  page
        return "redirect:/group/ShowGroupPage";
    }


    private List<String> ListOfDayInMonth() {
        Calendar calendar = Calendar.getInstance();
        int iYear = calendar.get(Calendar.YEAR);
        int iMonth = calendar.get(Calendar.MONTH);
        int iDay = 1;
// Create a calendar object and set year and month
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
// Get the number of days in that month
        List<String> listDayOfMonth = new ArrayList<>();
        String curentDate = null;
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            curentDate = i + "." + iMonth + "." + iYear;
            listDayOfMonth.add(curentDate);

        }
        return listDayOfMonth;
    }

    @RequestMapping("addPriceSubscription")
    private String addSubscriptionForm(Model theModel) {
        CustomerCard card = new CustomerCard();
        theModel.addAttribute("subscription", card);
        return "A_add_subscription_form";
    }

    @PostMapping("savePriceSubscription")
    private String savePriceSubscriptionForm(@ModelAttribute("subscription") CustomerCard card) {
        Group inGroup = groupService.getGroup(idGroup);


        return "A_add_subscription_form";
    }

    //take registered user
    public User getCurrentUser() throws NotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            System.out.println("error Vasia");
            ;
        }

        Object obj = auth.getPrincipal();
        String username = "";

        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }

        User u = userService.getUserByUsername(username);
        return u;
    }


    @RequestMapping(value = "/act", method = RequestMethod.POST)
    public String deleteListOfUsers(@RequestParam(value = "delete", required = false) String deletee,
                                    @RequestParam(value = "case", required = false) List<Long> ids,
                                    @RequestParam(value = "set", required = false) String set,
                                    @RequestParam(value = "selectedPrice", required = false) String price,
                                    @RequestParam(value = "selectedStartDate", required = false) String firstDte,
                                    @RequestParam(value = "selectedFinisfDate", required = false) String secondDate,
                                    @RequestParam(value = "selectedCode", required = false) String paymentStatus) {
        if (set != null) {

        }


       else if (deletee != null) {
            if (ids != null)

                for (int i = 0; i < ids.size(); i++) {
                    Student theStudent = studentService.getStudent(ids.get(i));
                    theStudent.setGroups(null);
                    studentService.addStudent(theStudent);
                }

        }
            return "redirect:/group//ShowGroupPage";
        }

        @RequestMapping("/showFormAddOrChangePriceAbonement")
        public  String showFormAddOrChangePrice( Model theModel){

            Price price = new Price();
            theModel.addAttribute("price", price);

            for(Price p: priceService.getAll()){
                if (idGroup==p.getGroups().getId()){
                    theModel.addAttribute("price",p);

                    break;
                }

            }

            return "a_small_fitness/add_form/A_small_fitness_addOrChange_price_of_abonement";
        }

    @PostMapping("/saveOrChangeAbonement")
    public String addOrChangeAbonement(@ModelAttribute("price") Price price) {

        boolean flag=true;
        Group group = groupService.getGroup(idGroup);
        if(!priceService.getAll().isEmpty() ) {
            for (Price p: priceService.getAll()){
                if ( p!=null && idGroup == p.getGroups().getId()){
                    System.out.println("in if check");
                        p.setPriceMonth(price.getPriceMonth());
                        p.setPriceMonthHalf(price.getPriceMonthHalf());
                        p.setPriceSingle(price.getPriceSingle());
                        priceService.addPrice(p);
                        flag=true;
                        break;
                    }
                    flag=false;
            }
            if (flag==false){
                price.setGroups(group);
                price.setUser(getCurrentUser());
                priceService.addPrice(price);
                    flag=true;
            }
        }

        if(priceService.getAll().isEmpty()) {
            System.out.println("in is empty");
            price.setGroups(group);
            price.setUser(getCurrentUser());
            priceService.addPrice(price);
        }
        return "redirect:/group/ShowGroupPage";
    }



}