package com.service;

import com.model.Code;
import com.model.User;

import java.util.Optional;

public interface CodeService {

    void add(Code code);

    Optional<Code> getLastCodeForUser(User user);

}
