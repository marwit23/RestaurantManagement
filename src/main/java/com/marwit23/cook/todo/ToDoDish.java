package com.marwit23.cook.todo;

import com.marwit23.cook.constants.ToDoStatus;

import com.marwit23.cook.dish.Dish;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Entity
public class ToDoDish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long toDoDishId;
    @OneToOne
    private Dish dish;
    private Date toDoDate;
    @Enumerated(EnumType.STRING)
    private ToDoStatus toDoStatus;

}
