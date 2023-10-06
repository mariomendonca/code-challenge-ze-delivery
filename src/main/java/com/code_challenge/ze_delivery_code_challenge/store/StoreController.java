package com.code_challenge.ze_delivery_code_challenge.store;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
@AllArgsConstructor
public class StoreController {

    @Autowired
    private final StoreService storeService;

    @GetMapping
    public List<Store> getStores() {
        return storeService.findAll();
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        System.out.println(store);
        return storeService.createStore(store);
    }
}
