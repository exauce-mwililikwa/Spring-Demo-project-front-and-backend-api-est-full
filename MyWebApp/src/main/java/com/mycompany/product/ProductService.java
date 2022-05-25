package com.mycompany.product;


import com.mycompany.role.Role;
import com.mycompany.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepo;
    public void saveProductDB(MultipartFile file,String description,int price ){
        Product p=new Product();
        String filename= StringUtils.cleanPath(file.getOriginalFilename());
        if(filename.contains("..")){
            System.out.println("not a valid file");
        }
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p.setDescription(description);
        p.setPrice(price);
productRepo.save(p);
    }

    public List<Product> listAll(){
        return (List<Product>) productRepo.findAll();
    }
}
