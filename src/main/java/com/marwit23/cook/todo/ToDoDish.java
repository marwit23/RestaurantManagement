package com.marwit23.cook.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marwit23.cook._constants.ToDoStatus;
import com.marwit23.cook.dish.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ToDoDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoDishId;

    @ManyToOne
    @JoinColumn(name = "dishId")
    private Dish dish;

    @Positive
    private int dishQuantity;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate toDoDate;

    @Enumerated(EnumType.STRING)
    private ToDoStatus toDoStatus = ToDoStatus.OPENED;

    public ToDoDish(Dish dish, LocalDate toDoDate, ToDoStatus toDoStatus, int dishQuantity) {
        this.dish = dish;
        this.toDoDate = toDoDate;
        this.toDoStatus = toDoStatus;
        this.dishQuantity = dishQuantity;
    }
}
