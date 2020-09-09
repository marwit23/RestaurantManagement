package com.marwit23.cook.todo;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/to-do-dishes")
public class ToDoDishController {

    private ToDoDishService toDoDishService;

    @Autowired
    public ToDoDishController(ToDoDishService toDoDishService) {
        this.toDoDishService = toDoDishService;
    }

    @GetMapping
    public List<ToDoDish> findAll(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "25") Integer pageSize,
            @RequestParam(defaultValue = "toDoDishId") String sortBy) {
        return toDoDishService.findAll(pageNo, pageSize, sortBy);
    }

    @PostMapping
    public ToDoDish addToDoDish(@RequestBody ToDoDish theToDoDish) {
        toDoDishService.save(theToDoDish);
        return theToDoDish;
    }

    @GetMapping("/{toDoDishId}")
    public ToDoDish findById(@PathVariable Long toDoDishId) {
        ToDoDish theToDoDish = toDoDishService.findById(toDoDishId);
        if(theToDoDish == null) throw new EntityNotFoundException("to-do dish", toDoDishId.toString());
        return theToDoDish;
    }

    @PutMapping
    public ToDoDish updateToDoDish(@RequestBody ToDoDish theToDoDish, @PathVariable Long toDoDishId) {
        theToDoDish.setToDoDishId(toDoDishId);
        toDoDishService.save(theToDoDish);
        return theToDoDish;
    }

    @DeleteMapping("/{toDoDishId}")
    public String deleteById(@PathVariable Long toDoDishId) {
        ToDoDish tempToDoDish = toDoDishService.findById(toDoDishId);
        if(tempToDoDish == null) throw new RuntimeException("To-do-dish Id not found - " + toDoDishId);
        toDoDishService.deleteById(toDoDishId);
        return "Deleted to-do-dish id - " + toDoDishId;
    }
}
