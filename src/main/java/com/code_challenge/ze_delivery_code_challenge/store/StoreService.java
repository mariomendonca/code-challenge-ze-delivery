package com.code_challenge.ze_delivery_code_challenge.store;

import com.code_challenge.ze_delivery_code_challenge.user.User;
import com.code_challenge.ze_delivery_code_challenge.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private UserService userService;

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public Store createStore(Store store, String userId) {
        User user = userService.findUserById(userId);
        store.setUser(user);
        return storeRepository.insert(store);
    }

    public Store getStoreById(String id) throws NoSuchElementException {
        return storeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Store not found with this id " + id));
    }

    public Store getNearestStore(double lat, double lng) {
        return storeRepository.findByCoverageAreaIntersects(List.of(lat, lng)).get(0);
    }

}
