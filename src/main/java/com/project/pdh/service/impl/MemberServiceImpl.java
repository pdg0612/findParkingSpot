package com.project.pdh.service.impl;

import com.project.pdh.domain.ChangePasswordRequest;
import com.project.pdh.domain.Member;
import com.project.pdh.domain.Sucess;
import com.project.pdh.entity.MemberEntity;
import com.project.pdh.repostitory.MemberRepository;
import com.project.pdh.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 생성자를 통한 의존성 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member join(Member member) {
        MemberEntity entity = Member.toEntity(member);
        memberRepository.save(entity);
        return member;
    }

    @Override
    public Sucess login(Member member) {
        Member loggedMember = Member.toDomain(memberRepository.findByEmail(member.getEmail()));
        System.out.println(loggedMember);
        if (loggedMember != null && loggedMember.getEmail().equals(member.getEmail()) && loggedMember.getPw().equals(member.getPw())) {
            Sucess success = new Sucess();
            success.setLogin(true);
            System.out.println(success.getLogin());
            return success;
        }
        return new Sucess();
    }

    @Override
    public Boolean update(String userId, String pw, String newPassword) {
        // userId를 이용하여 사용자 정보를 조회하고, 해당 사용자의 비밀번호가 pw와 일치하는지 확인
        MemberEntity member = memberRepository.findByEmail(userId);
        System.out.println(member);
        if (member != null && member.getPw().equals(pw)) {
            // 비밀번호가 일치하는 경우, 새로운 비밀번호로 변경
            member.setPw(newPassword);
            // 변경된 비밀번호로 사용자 정보 업데이트
            memberRepository.save(member);
            return true; // 비밀번호 변경 성공
        } else {
            return false; // 비밀번호 변경 실패
        }
    }


}
