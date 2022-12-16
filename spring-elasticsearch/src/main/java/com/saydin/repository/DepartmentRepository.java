package com.saydin.repository;

import com.saydin.model.Department;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends ElasticsearchRepository<Department,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    //just name mapping
    List<Department> getByNameCustomerQuery(String search);
    List<Department> findByNameLikeOrSubDepartmentLike();
    Department findDepartmentById();

}
