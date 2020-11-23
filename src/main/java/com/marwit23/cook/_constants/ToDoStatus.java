package com.marwit23.cook._constants;

public enum ToDoStatus {
    WAITING("waiting"),
    OPENED("opened"),
    DONE("done"),
    CANCELLED("cancelled");

    private final String displayValue;

    ToDoStatus(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }

}
