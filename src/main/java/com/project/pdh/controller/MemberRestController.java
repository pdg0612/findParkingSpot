package com.project.pdh.controller;


import com.project.pdh.domain.ChangePasswordRequest;
import com.project.pdh.domain.Member;
import com.project.pdh.domain.Sucess;
import com.project.pdh.service.MemberService;
import com.project.pdh.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/member")
public class MemberRestController {

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public Member joining(@RequestBody Member member) {
        System.out.println(member);
        return memberService.join(member);
    }
    @PostMapping("/login") // 세션에 담아주기
    public Sucess logining(@RequestBody Member member, HttpSession session) {
        Sucess success = memberService.login(member);
        if (success.getLogin()) {
            // 로그인이 성공했을 경우 세션에 로그인 상태를 저장
            session.setAttribute("UserID", member.getEmail());
        } else {
            // 로그인이 실패했을 경우 세션에 로그인 상태를 저장하지 않음
            session.setAttribute("UserID", false);
        }
        return success;
    }

    @PostMapping("/update/password")
    public ResponseEntity<?> updatePassword(@RequestBody ChangePasswordRequest request, HttpSession session) {
        // 세션에서 현재 로그인된 사용자의 ID를 가져옴
        String userId = (String) session.getAttribute("UserID");
        if (userId == null) {
            // 사용자가 로그인되어 있지 않은 경우
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        // 요청된 비밀번호 변경 정보를 서비스에 전달하여 처리
        boolean success = memberService.update(userId, request.getPw(), request.getNewPassword());
        if (success) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update password");
        }
    }
}
