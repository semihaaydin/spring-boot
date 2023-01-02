package com.saydin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO implements Serializable {
    private String type;
    private String modelCode;
    private String brandName;
}
