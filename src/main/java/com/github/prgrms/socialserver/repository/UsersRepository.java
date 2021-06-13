package com.github.prgrms.socialserver.repository;

import com.github.prgrms.socialserver.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
