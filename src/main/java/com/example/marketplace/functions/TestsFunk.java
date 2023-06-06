package com.example.marketplace.functions;

import com.example.marketplace.Object.Tests;
import com.example.marketplace.Repository.TestsRepository;
import org.springframework.stereotype.Service;

@Service
public class TestsFunk {

    private final TestsRepository testsRepository;

    public TestsFunk(TestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }

    public Iterable<Tests> getTests(){
        Iterable<Tests> tests= testsRepository.findAll();
        return tests;
    }
}
