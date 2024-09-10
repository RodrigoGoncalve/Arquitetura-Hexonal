package com.arantes.hexagonal.adapters.out.repository;

import com.arantes.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
