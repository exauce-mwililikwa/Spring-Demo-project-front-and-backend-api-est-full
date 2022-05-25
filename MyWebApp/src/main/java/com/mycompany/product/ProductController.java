package com.mycompany.product;
import com.mycompany.role.Role;
import com.mycompany.user.User;
import com.mycompany.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class ProductController {
    @Autowired private ProductRepository prodrep;
    @Autowired private ProductService prodserv;
    @PostMapping("/addP")
    public String saveProduct(@RequestParam("file")MultipartFile file, @RequestParam("description") String description, @RequestParam("price") int price){
      prodserv.saveProductDB(file,description,price);
      return "redirect:/";
    }
    @GetMapping("/product/add")
    public String showUserList(Model model){
         return "product";
    }

    @GetMapping("/product/list")
    public String showListUser(Model model){
        List<Product> products=prodserv.listAll();
        model.addAttribute("produitList",products);
        return "listProduct";
    }
}
