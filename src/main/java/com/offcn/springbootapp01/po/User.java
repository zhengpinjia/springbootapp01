package com.offcn.springbootapp01.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = false,length = 100)
    private String name;
    @Column(nullable = false,name = "age",length = 4)
    private Integer age;
}
