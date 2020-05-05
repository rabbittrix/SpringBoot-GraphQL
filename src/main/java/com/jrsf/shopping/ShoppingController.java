package com.jrsf.shopping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShoppingController {

    @GetMapping
    public String shopping() {
        return "Shopping REST";
    }
}
