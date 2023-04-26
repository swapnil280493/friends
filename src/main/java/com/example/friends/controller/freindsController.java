package com.example.friends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.friends.service.freindService;

import java.util.List;
import java.util.Map;

@RestController
public class freindsController {

    @Autowired
    freindService friendserv;

    @GetMapping("/get/{name}")
    public List<Map<Object, Object>> getPerson(@PathVariable String name){
         return friendserv.getPerson(name);
    }

    @GetMapping("/get")
    public List<Map<Object, Object>> getAllPerson(){
       return friendserv.getPersons();
    }
    @PostMapping("/add")
    public String addPerson(@RequestParam("name") String name){
         return friendserv.addPerson(name);
    }

    @PostMapping("/makefriend")
    public String makeFriend(@RequestParam("p1") String person1, @RequestParam("p2") String person2, @RequestParam("years") int years ){
        return friendserv.makeFriend(person1,person2,years);
    }

    @GetMapping("/get/directfriend/{name}")
    public List<Map<Object, Object>> getDirectFriend(@PathVariable String name){
        return friendserv.getDirectFriend(name);
    }
}
