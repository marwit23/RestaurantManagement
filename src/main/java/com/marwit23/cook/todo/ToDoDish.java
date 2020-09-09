package com.marwit23.cook.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marwit23.cook._constants.ToDoStatus;
import com.marwit23.cook.dish.Dish;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
public class ToDoDish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long toDoDishId;

    @OneToOne
    @JsonIgnoreProperties("dishIngredients")
    private Dish dish;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate toDoDate;

    @Enumerated(EnumType.STRING)
    private ToDoStatus toDoStatus;
}
