package com.Altera.task.service;

import com.Altera.task.entity.User;
import com.Altera.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User create(User user){
        return userRepository.save(user);
    }

    public User findOne(Integer id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void deleteOne(Integer id) {

        userRepository.deleteById(id);
    }


}
