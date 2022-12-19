package com.saydin.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="address")
    private String address;

    @Enumerated
    private AdressType addressType;

    @Column (name = "active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="addess_id")
    private Employment employment;

    public enum AdressType{
        HOME,
        WORK,
        TEMPORARY,
        OTHER
    }
}
