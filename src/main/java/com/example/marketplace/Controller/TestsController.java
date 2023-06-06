package com.example.marketplace.Controller;

import com.example.marketplace.Object.*;
import com.example.marketplace.Repository.*;
import com.example.marketplace.functions.TestsFunk;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class TestsController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResponseUserTestRepository responseUserTestRepository;
    @Autowired
    private ResponseOptionsRepository responseOptionsRepository;

    @Autowired
    private TestsRepository testsRepository;
    @Autowired
    private BallRepository ballRepository;

    @PostMapping("/2")
    public String aa(@RequestParam Map<String,String> allRequestParams) {
        Tests test=null;
        int ball=0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        for (Map.Entry<String,String> entry : allRequestParams.entrySet()) {
            if (entry.getKey().startsWith("tests_")){
                int test_id=0;
                String t = entry.getKey().substring(6);
                test_id=Integer.parseInt(t);
                test=testsRepository.findById(test_id).get();
            }
            if (entry.getKey().startsWith("question_")) {
                String questionId = entry.getKey().substring(9);
                Long selectedOptionId = Long.parseLong(entry.getValue());

                ResponseUserTest responseUserTest = new ResponseUserTest();
                responseUserTest.setResponseOptionsId(selectedOptionId);
                ball = ball + responseOptionsRepository.findById(selectedOptionId.longValue()).get().getBall();
                responseUserTest.setTests(test);

                responseUserTest.setUser(user);

                responseUserTestRepository.save(responseUserTest);
            }
        }
        Ball ballobj = new Ball();
        ballobj.setUser(user);
        ballobj.setTests(test);
        double percentage = ((double) ball / test.getMaxball()) * 100;
        int roundedPercentage = (int) Math.round(percentage);
        ballobj.setBall(ball);
        ballobj.setPercent(roundedPercentage);
        ballRepository.save(ballobj);
        return "redirect:";
    }
}
