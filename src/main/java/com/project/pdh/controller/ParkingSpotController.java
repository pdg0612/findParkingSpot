package com.project.pdh.controller;

import com.project.pdh.domain.NeedInfo;
import com.project.pdh.service.MemberService;
import com.project.pdh.service.NeedInfoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ParkingSpotController {

    private final NeedInfoService needInfoService;
    private final MemberService memberService;

    public ParkingSpotController(NeedInfoService needInfoService, MemberService memberService) {
        this.needInfoService = needInfoService;
        this.memberService = memberService;
    }


    @GetMapping("")
    public String home(HttpServletRequest request, Model model, @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber, @RequestParam(value = "search", required = false) String search) {
        HttpSession session = request.getSession(false);

//         세션이 없거나 로그인 상태가 아니라면 로그인 페이지로 리다이렉트
        if (session == null || session.getAttribute("UserID") == null) {
            return "redirect:/member/";
        }

        // 페이지 번호와 검색어를 기반으로 필요한 정보를 가져오는 서비스 메소드 호출
        Page<NeedInfo> needInfoList = needInfoService.readAll(pageNumber, search);

        // 모델에 페이지 정보를 추가하여 뷰에 전달
        model.addAttribute("page", needInfoList);

        // 로그인한 사용자인 경우 홈 페이지 반환
        return "list";
    }

    @GetMapping("/mypage")
    public String myPage(HttpServletRequest request, Model model) {
        // 세션에서 사용자 ID 가져오기
        HttpSession session = request.getSession(false);
        if (session != null) {
            String userId = (String) session.getAttribute("UserID");
            System.out.println(userId);
            if (userId != null) {
                model.addAttribute("userId", userId);
                return "mypage";
            }
        }
        // 세션에 사용자 ID가 없으면 로그인 페이지로 리디렉션
        return "redirect:/";
    }
}
