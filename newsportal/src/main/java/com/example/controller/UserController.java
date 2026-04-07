package com.example.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // React port
public class UserController {

    @GetMapping("/users")
    public List<Map<String, String>> getUsers() {
        List<Map<String, String>> users = new ArrayList<>();
        Map<String, String> user1 = new HashMap<>();
        user1.put("id", "1");
        user1.put("name", "Amit Sharma");
        user1.put("email", "amit@gmail.com");
        user1.put("phone", "9876543210");
        Map<String, String> user2 = new HashMap<>();
        user2.put("id", "2");
        user2.put("name", "Priya Rao");
        user2.put("email", "priya@gmail.com");
        user2.put("phone", "9876501234");
        users.add(user1);
        users.add(user2);
        return users;
    }
}
