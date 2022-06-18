package main;

import main.model.DoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.model.Do;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DoController {

    @Autowired
    private DoRepository doRepository;

    @GetMapping("/doings/")
    public List<Do> list () {
        Iterable<Do> iterable = doRepository.findAll();
        List<Do> todolist = new ArrayList<>();
        iterable.forEach(e -> todolist.add(e));
        return todolist;
    }

    @PostMapping("/doings/")
    public synchronized int add (Do myDo) {
        Do newDo = doRepository.save(myDo);
        return newDo.getId();
    }

    @GetMapping("/doings/{id}")
    public synchronized ResponseEntity get (@PathVariable int id) {
        Optional<Do> optionalDo = doRepository.findById(id);
        if (!optionalDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalDo.get(), HttpStatus.OK);
    }
    @DeleteMapping("/doings/{id}")
    public synchronized ResponseEntity remove(@PathVariable int id) {
        Optional<Do> optionalDo = doRepository.findById(id);
        if (!optionalDo.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        doRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
