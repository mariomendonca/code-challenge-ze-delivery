package com.code_challenge.ze_delivery_code_challenge.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getStores() {
        return ResponseEntity.ok().body(storeService.findAll());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Store> createStore(@RequestBody Store store, @PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createStore(store, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable String id) {
        return  ResponseEntity.ok().body(storeService.getStoreById(id));
    }

    @GetMapping("/nearest")
    public ResponseEntity<Store> getNearestByLatLng(
            @RequestParam double lat,
            @RequestParam double lng
    ) {
        return ResponseEntity.ok().body(storeService.getNearestStore(lat, lng));
    }
}
