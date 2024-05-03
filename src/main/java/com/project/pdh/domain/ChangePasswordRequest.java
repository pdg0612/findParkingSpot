package com.project.pdh.domain;


import com.project.pdh.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChangePasswordRequest {
    private String email;
    private String pw;
    private String newPassword;
}
