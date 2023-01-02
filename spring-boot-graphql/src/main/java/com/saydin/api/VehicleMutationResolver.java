package com.saydin.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.saydin.dto.VehicleDTO;
import com.saydin.entity.Vehicle;
import com.saydin.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private final VehicleRepository repository;

    public VehicleMutationResolver(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle createVehicle(VehicleDTO vehicleDTO){
        return repository.save(dtoToEntity(vehicleDTO));
    }

    private Vehicle dtoToEntity(VehicleDTO vehicleDTO){
        Vehicle vehicle=new Vehicle();
        vehicle.setBrandName(vehicleDTO.getBrandName());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setModelCode(vehicleDTO.getModelCode());
         return vehicle;
    }
}
