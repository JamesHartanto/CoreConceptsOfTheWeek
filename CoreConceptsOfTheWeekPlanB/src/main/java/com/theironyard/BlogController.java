package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by JamesHartanto on 4/20/17.
 */
@Controller
public class BlogController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonService personService;

    // Provide login details
    @RequestMapping("/")
//    @GetMapping("/")
    public String loginPage(HttpSession session, Model model, String username){
        model.addAttribute("username",username);    
        return "index";
    }

    // Check if inputs are acceptable
    @RequestMapping("/login")
//    @PostMapping("/login")
    public String login(Model model, String username, String password){
        model.addAttribute("username",username);
        model.addAttribute("password",password);

        if (personService.usernameList(personRepository.listPeople()).contains(username)){
            // Check the password is correct
            Person personToCheck = personRepository.findPerson(username);
            if (personToCheck.getPassword().equals(password)){
                return "redirect:/homePage";
            } else {
                return "redirect:/badLogin";
            }
        } else {
            return "redirect:/badLogin";
        }
    }

    // login page with error message
    @RequestMapping("/badLogin")
    public String badLogin(Model model, String username){
        model.addAttribute("username",username);
        return "badLogin";
    }

    // Creates new user, checks if username was taken
    @RequestMapping("/newUser")
//    @GetMapping("/newUser")
    public String newUser(Model model, String username, String password1, String password2) {
        if (username == null || password1 == null || password2 == null){
            return "/newUser";
        }
        // Checks to see unique username and validity of password inputs
        if (personService.uniqueUsername(username,personService.usernameList(personRepository.listPeople())) && (password1.equals(password2))) {
            Person person = new Person(username,password1);
            person.setUsername(username);
            person.setPassword(password1);
            personRepository.createPerson(person);
            return "redirect:/";
        } else {
            return "redirect:/badNewUser";
        }
    }

    // new user with bad input
    @RequestMapping("/badNewUser")
    public String badNewUser() {
        // has error message, still links back to newUser for logic
        return "/badNewUser";
    }



    // Home Page of the blog
    @RequestMapping("/homePage")
    public String homePage(){
        return "/homePage";
    }

    // Creating a blog
    @RequestMapping("/createBlog")
    public String createBlog(){
        return "createBlog";
    }

    // View a blog post
    @RequestMapping("/viewBlogPost")
    public String viewBlogPost(){
        return "viewBlogPost";
    }

    // Edit Delete ONLY IF YOU ARE THE AUTHOR
    @RequestMapping("/editDeletePost")
    public String editDelete(Integer idOfPost){
        // need to check that person_id of post belongs to
        return "redirect:/viewBlogPost";
    }

    // logout
    @RequestMapping(path = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
