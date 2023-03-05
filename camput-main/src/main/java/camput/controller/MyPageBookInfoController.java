package camput.controller;



import camput.dto.MyPageCampDto;
import camput.service.LoginCheckService;
import camput.service.MemberService;
import camput.service.MyPageBookInfoService;
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
@RequestMapping("camput/")
@RequiredArgsConstructor
@Slf4j
public class MyPageBookInfoController {

    private final MyPageBookInfoService myPageBookInfoService;
    private final MemberService memberService;
    private final LoginCheckService loginCheckService;

    @GetMapping("myPage/bookInfo")
    public String myPageBookInfo(Model model, HttpServletRequest request, Pageable pageable){
        String loginId = loginCheckService.checkLogin(request);
        String memberNickName = memberService.findMemberNickName(loginId);
        Page<MyPageCampDto> bookedCampDtos = myPageBookInfoService.bookedCamp(loginId, pageable);
        int totalPage= bookedCampDtos.getTotalPages()-1;
        model.addAttribute("member",loginId);
        model.addAttribute("memberNickName",memberNickName);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("bookedCamps",bookedCampDtos);
        return "/myPageCheckReservation";
    }
}
