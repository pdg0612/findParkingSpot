package com.project.pdh.repostitory;

import com.project.pdh.domain.Member;
import com.project.pdh.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByEmail(String email);
}
