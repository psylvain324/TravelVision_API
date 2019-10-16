package com.travel.vision.api.repositories;

import com.travel.vision.api.models.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>, JpaSpecificationExecutor<Employee> {
    Employee save(Employee employee);
    Page<Employee> findAll(Pageable pageable);
}
