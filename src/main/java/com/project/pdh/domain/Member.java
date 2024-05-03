package com.project.pdh.domain;


import com.project.pdh.entity.MemberEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(unique = true)
    private String email;


    private String pw;

    public static Member toDomain(MemberEntity entity) {
        return Member.builder()
                .idx(entity.getIdx())
                .email(entity.getEmail())
                .pw(entity.getPw())
                .build();
    }

    public static MemberEntity toEntity(Member member) {
        return MemberEntity.builder()
                .idx(member.getIdx())
                .email(member.getEmail())
                .pw(member.getPw())
                .build();
    }

    public boolean checkPassword(String password){
        return this.pw.equals(password);
    }
}
