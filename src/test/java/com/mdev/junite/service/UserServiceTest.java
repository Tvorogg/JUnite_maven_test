package com.mdev.junite.service;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)

class UserServiceTest {

    private UserService userService;

    @BeforeAll
    static void init(){
        System.out.println("Before All: ");
    }

    @BeforeEach
    void prepare(){
        System.out.println("Before Each: " + this);
       userService = new UserService();
    }


    @Test
    void usersEmptyIfNoUserAdded(){
        System.out.println("Test_1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty());
    }
    @Test
    void userSizeIfUserAdded(){
        System.out.println("Test_2: " + this);
        userService.add(new User());
        userService.add(new User());

        var users = userService.getAll();
        assertEquals(2,users.size());
    }
    @AfterEach
    void deleteDataFromDataBase(){
        System.out.println("After Each: " + this);
    }
    @AfterAll
    static void closeConnectionPool(){
        System.out.println("After All: ");
    }
}
