package com.marwit23.cook.todo;

import java.util.List;

public interface ToDoDishService {

    List<ToDoDish> findAll(Integer pageNo, Integer pageSize, String sortBy);
    ToDoDish findById(Long toDoDishId);
    void save(ToDoDish theToDoDish);
    void deleteById(Long toDoDishId);
}
