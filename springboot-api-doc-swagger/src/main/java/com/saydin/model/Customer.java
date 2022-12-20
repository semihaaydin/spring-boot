package com.saydin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Customer",description = "Core Customer Model ")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name="company",length = 100)
    @ApiModelProperty(value = "company name must be uniq ")
    private String company;

    @Column(name="name",length = 100)
    private String name;

}
