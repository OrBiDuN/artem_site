package com.example.marketplace.Repository;

import com.example.marketplace.Object.Ball;
import com.example.marketplace.Object.ResponseUserTest;
import com.example.marketplace.Object.Tests;
import com.example.marketplace.Object.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BallRepository extends CrudRepository<Ball, Integer> {
    ArrayList<Ball> findAllByTestsAndUser(Tests tests, User user);
}