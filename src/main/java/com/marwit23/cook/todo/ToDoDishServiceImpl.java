package com.marwit23.cook.todo;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoDishServiceImpl implements ToDoDishService {

    private ToDoDishRepository toDoDishRepository;

    @Autowired
    public ToDoDishServiceImpl(ToDoDishRepository toDoDishRepository) {
        this.toDoDishRepository = toDoDishRepository;
    }

    @Override
    public List<ToDoDish> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ToDoDish> toDoDishPage = toDoDishRepository.findAll(pageable);
        return toDoDishPage.getContent();
    }

    @Override
    public ToDoDish findById(Long toDoDishId) {
        Optional<ToDoDish> result = toDoDishRepository.findById(toDoDishId);
        ToDoDish theToDoDish;
        if(result.isPresent()) theToDoDish = result.get();
        else throw new EntityNotFoundException("to-do dish", toDoDishId.toString());
        return theToDoDish;
    }

    @Override
    public void save(ToDoDish theToDoDish) {
        toDoDishRepository.save(theToDoDish);
    }

    @Override
    public void deleteById(Long toDoDishId) {
        toDoDishRepository.deleteById(toDoDishId);
    }
}
