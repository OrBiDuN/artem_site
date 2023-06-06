package com.example.marketplace.Repository;

import com.example.marketplace.Object.Ball;
import com.example.marketplace.Object.ResponseOptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseOptionsRepository extends CrudRepository<ResponseOptions, Long> {
}
