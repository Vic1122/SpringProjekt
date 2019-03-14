package com.Vic1122.Library.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Here {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date hireDate;
    private Date plannedgiveBackDate;
    private Date realgiveBackDate;

    @OneToOne
    private User hirerUser;

    @ManyToOne
    private Book hiredBook;

}
