package com.saydin.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "department" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Department {
    @Id
    private String id;

    @Field(name="name",type = FieldType.Text)
    private String name;

    @Field(name="subDepartment",type = FieldType.Text)
    private String subDepartment;


}
