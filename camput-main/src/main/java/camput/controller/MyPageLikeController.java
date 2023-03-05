package camput.controller;

import camput.dto.MyPageCampDto;
import camput.service.LoginCheckService;
import camput.service.MemberService;
import camput.service.MyPageLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/camput")
@RequiredArgsConstructor
@Slf4j
public class MyPageLikeController {
    private final MyPageLikeService myPageLikeService;
    private final MemberService memberService;
    private final LoginCheckService loginCheckService;

    @GetMapping("/myPage/like")
    public String myPageLike(Model model, Pageable pageable, HttpServletRequest request){
        String loginId = loginCheckService.checkLogin(request);
        String memberNickName = memberService.findMemberNickName(loginId);
        log.info("loginId={}",loginId);
        log.info("memberNickName={}",memberNickName);
        Page<MyPageCampDto> myPageCampDtos = myPageLikeService.likeCamps(loginId,pageable);
        log.info("myPageCampDtos={}",myPageCampDtos.getTotalElements());
        Page<MyPageCampDto> content = myPageCampDtos;
        int totalPage= myPageCampDtos.getTotalPages()-1;
        model.addAttribute("member",loginId);
        model.addAttribute("memberNickName",memberNickName);
        model.addAttribute("likeCamps",content);
        model.addAttribute("totalPage",totalPage);
        return "/myPageLike";
    }
}
