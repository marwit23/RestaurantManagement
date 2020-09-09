package com.marwit23.cook.todo;

import java.util.List;

public interface ToDoDishService {

    public List<ToDoDish> findAll(Integer pageNo, Integer pageSize, String sortBy);
    public ToDoDish findById(Long toDoDishId);
    public void save(ToDoDish theToDoDish);
    public void deleteById(Long toDoDishId);
}
