package com.marwit23.cook.todo;

import com.marwit23.cook._exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/to-do-dishes")
public class ToDoDishController {

    private ToDoDishService toDoDishService;
    private ToDoDishMapper toDoDishMapper;

    @Autowired
    public ToDoDishController(ToDoDishService toDoDishService, ToDoDishMapper toDoDishMapper) {
        this.toDoDishService = toDoDishService;
        this.toDoDishMapper = toDoDishMapper;
    }

    @GetMapping
    public List<ToDoDishDTO> findAll() {
        List<ToDoDish> theToDoDishes = toDoDishService.findAll();
        return theToDoDishes.stream()
                .map(toDoDish -> toDoDishMapper.convertToDto(toDoDish))
                .collect(Collectors.toList());
    }

//    @GetMapping
//    public List<ToDoDish> findAll(
//            @RequestParam(defaultValue = "0") Integer pageNo,
//            @RequestParam(defaultValue = "25") Integer pageSize,
//            @RequestParam(defaultValue = "toDoDishId") String sortBy) {
//        return toDoDishService.findAll(pageNo, pageSize, sortBy);
//    }

    @PostMapping
    public ToDoDishDTO addToDoDish(@RequestBody ToDoDishDTO theToDoDishDTO) {
        ToDoDish theToDoDish = toDoDishMapper.convertToEntity(theToDoDishDTO);
        toDoDishService.save(theToDoDish);
        return toDoDishMapper.convertToDto(theToDoDish);
    }

    @GetMapping("/{toDoDishId}")
    public ToDoDishDTO findById(@PathVariable Long toDoDishId) {
        ToDoDish theToDoDish = toDoDishService.findById(toDoDishId);
        ToDoDishDTO theToDoDishDTO = toDoDishMapper.convertToDto(theToDoDish);
        if(theToDoDish == null) throw new EntityNotFoundException("to-do dish", toDoDishId.toString());
        return theToDoDishDTO;
    }

    @PutMapping
    public ToDoDishDTO updateToDoDish(@RequestBody ToDoDishDTO toDoDishDto, @PathVariable Long toDoDishId) {
        ToDoDish theToDoDish = toDoDishMapper.convertToEntity(toDoDishDto);
        theToDoDish.setToDoDishId(toDoDishId);
        toDoDishService.save(theToDoDish);
        return toDoDishMapper.convertToDto(theToDoDish);
    }

    @DeleteMapping("/{toDoDishId}")
    public String deleteById(@PathVariable Long toDoDishId) {
        ToDoDish tempToDoDish = toDoDishService.findById(toDoDishId);
        if(tempToDoDish == null) throw new RuntimeException("To-do-dish Id not found - " + toDoDishId);
        toDoDishService.deleteById(toDoDishId);
        return "Deleted to-do-dish id - " + toDoDishId;
    }
}
