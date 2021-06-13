package com.github.prgrms.socialserver.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired UsersRepository usersRepository;

    @Test
    void select() {
        usersRepository.findAll().forEach(System.out::println);
    }

}