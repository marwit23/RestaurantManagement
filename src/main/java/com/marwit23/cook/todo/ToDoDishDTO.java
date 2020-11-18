package com.marwit23.cook.todo;

import com.marwit23.cook._constants.ToDoStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ToDoDishDTO {

    private long toDoDishId;
    private String dishName;
    private LocalDate toDoDate;
    private ToDoStatus toDoStatus;
}
