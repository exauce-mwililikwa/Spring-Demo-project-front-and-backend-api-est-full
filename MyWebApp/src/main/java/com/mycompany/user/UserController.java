package com.mycompany.user;

import com.mycompany.role.Role;
import com.mycompany.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;
    @Autowired private RoleService service1;
    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> userList=service.listAll();
        model.addAttribute("userList",userList);
        return "users";
    }
    @GetMapping("/users/new")
    public String shownweform(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle","Add new user");

        List<Role> roleList=service1.listAll();
        model.addAttribute("roleList",roleList);
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra){
        service.save(user);
        ra.addFlashAttribute("message","The user has been saved successfull");

        return "redirect:/users";
    }
    @GetMapping("users/edit/{id}")
   public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
   try{
     User user=  service.get(id);
       model.addAttribute("pageTitle","Edit user(ID:"+id+" )");

       model.addAttribute("user",user);
       return "user_form";
   }
   catch (UserNotFoundException e){
       ra.addFlashAttribute("message","The user has been update successfull");

       return "redirect:/users";
   }
    }
    @GetMapping("users/delete/{id}")
    public String DeleteForm(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.delete(id);

        }
        catch (UserNotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());


        }
        return "redirect:/users";
    }
}
