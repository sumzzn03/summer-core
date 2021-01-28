package am.zzz.beans.instance;

import am.zzz.dependency.domain.User;

public class DefaultUserFactory implements UserFactory {

    @Override
    public User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("小熊熊");
        return user;
    }
}
