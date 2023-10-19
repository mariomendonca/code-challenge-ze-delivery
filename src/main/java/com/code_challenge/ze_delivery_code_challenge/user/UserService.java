package com.code_challenge.ze_delivery_code_challenge.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found with this id " + id));
    }
}
