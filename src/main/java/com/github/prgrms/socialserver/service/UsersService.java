package com.github.prgrms.socialserver.service;

import com.github.prgrms.socialserver.domain.Users;
import com.github.prgrms.socialserver.dto.UserJoinDto;
import com.github.prgrms.socialserver.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@NoArgsConstructor
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findUsersAll() {
        return usersRepository.findAll();
    }

    public Users findUserById(Long userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    @Transactional
    public Long joinUser(UserJoinDto userJoinDto) {
        Users user = userJoinDto.toEntity();
        usersRepository.save(user);
        return user.getSeq();
    }
}
