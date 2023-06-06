package com.example.marketplace.Controller;

import com.example.marketplace.Object.Ball;
import com.example.marketplace.Object.Tests;
import com.example.marketplace.Object.User;
import com.example.marketplace.Repository.BallRepository;
import com.example.marketplace.Repository.TestsRepository;
import com.example.marketplace.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeContorller {

    @Autowired
    private TestsRepository testsRepository;
    @Autowired
    private BallRepository ballRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String a(Model model){
        List<Tests> suc80 = new ArrayList<>();
        List<Tests> suc0 = new ArrayList<>();
        List<Tests> suc80no = new ArrayList<>();
        List<Tests> testsList = (List<Tests>) testsRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        for(Tests test : testsList){
            ArrayList<Ball> ball = ballRepository.findAllByTestsAndUser(test, user);
            if(ball.isEmpty()){
                suc0.add(test);
            }else{
                if(ball.get(ball.size()-1).getPercent()>80){
                    suc80.add(test);
                }
                if(ball.get(ball.size()-1).getPercent()<80){
                    suc80no.add(test);
                }
            }
        }
        model.addAttribute("tests_0", suc0);
        model.addAttribute("tests_sucno", suc80no);
        model.addAttribute("tests_suc", suc80);
        return "1";
    }
    @GetMapping("/2")
    public String aa(@RequestParam Integer test_id, Model model){
        Optional<Tests> tests = testsRepository.findById(test_id);
        model.addAttribute("tests", tests.get());
        model.addAttribute("questions",tests.get().getQuestions());
        return "2";
    }
}
