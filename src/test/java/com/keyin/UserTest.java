package com.keyin;

import com.keyin.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testUserSetters(){
        User user = new User();
        String test = "test";
        user.setUserInput(test);
        Assertions.assertEquals(test, user.getUserInput());
    }
}
