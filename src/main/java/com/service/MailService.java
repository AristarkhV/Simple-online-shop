package com.service;

import com.model.Code;

public interface MailService {

    void sendOneTimeCode(Code code, String email);

}
