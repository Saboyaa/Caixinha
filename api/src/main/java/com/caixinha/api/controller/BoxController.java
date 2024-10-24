package com.caixinha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caixinha.api.entity.Box;
import com.caixinha.api.entity.BoxInterface;
import com.caixinha.api.service.BoxService;

@RestController
public class BoxController {
    private BoxService boxService;

    @Autowired
    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping("/boxs/{boxNumber}")
    public Box getBoxById(@PathVariable String boxNumber) {
        Box box = boxService.findByBoxNumber(boxNumber);

        if (boxNumber == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + boxNumber);
        }

        return box;
    }

    @GetMapping("/boxs/userId/{userId}")
    public List<BoxInterface> getBoxByUserId(@PathVariable int userId) {
        return boxService.findByUserId(userId);
    }

    @PostMapping("/boxs")
    public Box addBox(@RequestBody Box box) {
        Box dbBox = boxService.save(box);

        return dbBox;
    }

    @PutMapping("/boxs/{boxNumber}")
    public Box updateBox(@RequestBody Box box, @RequestParam String boxNumber) {
        Box tempBox = boxService.findByBoxNumber(boxNumber);

        if (tempBox == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + boxNumber);
        }

        Box dbBox = boxService.update(box);

        return dbBox;
    }

    @DeleteMapping("/boxs/{boxNumber}") 
    public String deleteBox(@PathVariable String boxNumber) {
        Box tempBox = boxService.findByBoxNumber(boxNumber);

        if (tempBox == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + boxNumber);
        }

        boxService.deleteByBoxNumber(boxNumber);

        return "Deletou conta de número " + boxNumber;
    }
}
