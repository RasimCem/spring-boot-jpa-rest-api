package com.artwork.Service;

import com.artwork.Model.UserDO;
import com.artwork.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDO createUser(UserDO user) {
        return userRepository.save(user);
    }

    @Override
    public UserDO getUser(Long user_id) {
        Optional<UserDO> currentUser = userRepository.findById(user_id);
        if(currentUser.isPresent()){
            return currentUser.get();
        }
        return null;
    }
}
