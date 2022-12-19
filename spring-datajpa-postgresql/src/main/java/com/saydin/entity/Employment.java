package com.saydin.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Employment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( length = 100 , name="name")
    private String name;

    @Column(length = 100, name="surname")
    private String surname;

    @OneToMany
            @JoinColumn(name="addess_id")
    List<Address> addressList;

}
