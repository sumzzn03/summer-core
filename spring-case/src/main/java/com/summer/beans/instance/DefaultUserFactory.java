package com.summer.beans.instance;

import com.summer.domain.User;

public class DefaultUserFactory implements UserFactory {

    @Override
    public User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("小熊熊");
        return user;
    }
}
