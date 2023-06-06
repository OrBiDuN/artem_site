package com.example.marketplace.Repository;

import com.example.marketplace.Object.ResponseUserTest;
import com.example.marketplace.Object.Tests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseUserTestRepository extends CrudRepository<ResponseUserTest, Integer> {
}
