package com.example.marketplace.Repository;

import com.example.marketplace.Object.Tests;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TestsRepository extends CrudRepository<Tests, Integer> {
}
