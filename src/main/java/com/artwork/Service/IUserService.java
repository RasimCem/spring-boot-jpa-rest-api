package com.artwork.Service;

import com.artwork.Model.UserDO;

public interface IUserService {
    public UserDO createUser(UserDO user);
    public UserDO getUser(Long user_id);
}
