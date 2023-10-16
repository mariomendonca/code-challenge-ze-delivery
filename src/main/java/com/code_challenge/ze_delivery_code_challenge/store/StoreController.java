package com.code_challenge.ze_delivery_code_challenge.store;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
@AllArgsConstructor
public class StoreController {

    @Autowired
    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getStores() {
        return ResponseEntity.ok().body(storeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store store) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createStore(store));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable String id) {
        return  ResponseEntity.ok().body(storeService.getStoreById(id));
    }
}
