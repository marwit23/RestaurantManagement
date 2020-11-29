package com.marwit23.cook.todo;

import java.util.List;

public interface ToDoDishService {
    List<ToDoDish> findAll();
    List<ToDoDish> findAllWithParams(Integer pageNo, Integer pageSize, String sortBy);
    ToDoDish findById(Long toDoDishId);
    void save(ToDoDish theToDoDish);
    void update(ToDoDish theToDoDish, Long toDoDishId);
    void deleteById(Long toDoDishId);
}
