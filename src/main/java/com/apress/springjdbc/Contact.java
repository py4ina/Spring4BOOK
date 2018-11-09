package com.apress.springjdbc;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;


}
