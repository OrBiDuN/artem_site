package com.example.marketplace.Controller;

import com.example.marketplace.Object.Film;
import com.example.marketplace.Object.Role;
import com.example.marketplace.Object.User;
import com.example.marketplace.Repository.FilmRepositoty;
import com.example.marketplace.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;



import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Map;

@Controller
public class HomeContorller {

    @GetMapping("/")
    public String a(Model model){
        return "1";
    }
    @GetMapping("/2")
    public String aa(Model model){
        return "2";
    }
    @GetMapping("/login")
    public String aaa(){
        return "login";
    }

    @GetMapping("/exit")
    public String exit(){return "exit";}
    @GetMapping("/reg")
    public String registration(){return "reg";}
    /*@PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("message", "Логин занят");
            return "reg";
        }
        userRepository.save(user);
        return "redirect:/login";
    }*/
}
