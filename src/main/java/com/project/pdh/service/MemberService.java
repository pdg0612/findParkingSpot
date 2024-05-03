package com.project.pdh.service;

import com.project.pdh.domain.ChangePasswordRequest;
import com.project.pdh.domain.Member;
import com.project.pdh.domain.Sucess;

public interface MemberService {

    Member join(Member member);

    Sucess login(Member member);

    Boolean update(String userId, String pw, String newPassword);
}
