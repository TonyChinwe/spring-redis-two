package com.phisoft.springreactiveredisone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;

}
