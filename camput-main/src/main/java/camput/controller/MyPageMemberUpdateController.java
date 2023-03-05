package camput.controller;

import camput.dto.MemberJoinDto;
import camput.service.JoinService;
import camput.service.LoginCheckService;
import camput.service.MemberUpdateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageMemberUpdateController {
    private final MemberUpdateService memberUpdateService;
    private final JoinService joinService;
    private final LoginCheckService loginCheckService;

    @GetMapping("/member/update")
    public String intoPage(Model model, HttpServletRequest request){
        String loginId = loginCheckService.checkLogin(request);
        MemberJoinDto result = memberUpdateService.view(loginId);
        model.addAttribute("loginMember", result);
        model.addAttribute("member",loginId);
        return "myPageMemberUpdate";
    }

    @PostMapping("/member/update")
    @ResponseBody
    public String update(@ModelAttribute MemberJoinDto memberJoinDto){
        System.out.println("memberJoinDto = " + memberJoinDto);
        return "/camput/myPage/information";
    }

}
