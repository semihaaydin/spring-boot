package com.saydin.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.saydin.entity.Vehicle;
import com.saydin.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQueryResolver  implements GraphQLQueryResolver {

    @Autowired
    private final VehicleRepository repository;

    public VehicleQueryResolver(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> getVehiclesByType(String type){
        return repository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){
        return repository.getFindById(id);
    }
}
