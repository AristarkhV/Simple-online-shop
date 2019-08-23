package com.service.impl;

import com.model.Code;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.CodeJpaRepository;
import com.service.CodeService;

import java.util.Optional;

@Service
@Transactional
public class CodeServiceImpl implements CodeService {

    private CodeJpaRepository jpaRepository;

    @Autowired
    public CodeServiceImpl(CodeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public void add(Code code) {
        jpaRepository.saveAndFlush(code);
    }

    public Optional<Code> getLastCodeForUser(User user) {
        return jpaRepository.findCodeByUserOrderByIdDesc(user);
    }

}
