package com.code_challenge.ze_delivery_code_challenge.store;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService {

    @Autowired
    private final StoreRepository storeRepository;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store createStore(Store store) {
        return storeRepository.insert(store);
    }

    public Store getStoreById(String id) throws NoSuchElementException {
        return storeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Store not found with this id " + id));
    }

}
