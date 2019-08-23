package com.repository;

import com.model.Code;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeJpaRepository extends JpaRepository<Code, Long> {

    Optional<Code> findCodeByUserOrderByIdDesc(User user);

}
