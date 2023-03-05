package camput.controller;

import camput.dto.CampCommentDto;
import camput.dto.MemberInfoDto;
import camput.service.CampCommentService;
import camput.service.LoginCheckService;
import camput.service.MemberService;
import camput.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/camput")
public class ReviewController {
    private final CampCommentService campCommentService;
    private final LoginCheckService loginCheckService;
    private final MemberService memberService;

    @PostMapping("/reviews/insert") // 새글
    @ResponseBody
    public Boolean createReview(@ModelAttribute CampCommentDto commentDto, HttpServletRequest request) {
        String loginId = loginCheckService.checkLogin(request);
        MemberInfoDto memberInfoDto = memberService.findMemberInfo(loginId);
        Member member = Member.builder()
                .memberLoginId(memberInfoDto.getMemberLoginId())
                .nickName(memberInfoDto.getNickName())
                .id(memberInfoDto.getId())
                .build();
        commentDto.setMember(member);
        campCommentService.save(commentDto);
        return true;
    }
   @PostMapping("/reviews/update") // 수정 - 아이디로 불러와서 수정
   @ResponseBody
    public Boolean updateReview(@ModelAttribute CampCommentDto commentDto, HttpServletRequest request) {
       String loginId = loginCheckService.checkLogin(request);
       MemberInfoDto memberInfoDto = memberService.findMemberInfo(loginId);
       Member member = Member.builder()
               .memberLoginId(memberInfoDto.getMemberLoginId())
               .nickName(memberInfoDto.getNickName())
               .id(memberInfoDto.getId())
               .build();
       commentDto.setMember(member);
       campCommentService.update(commentDto);
       return true;
   }

    @GetMapping("/reviews/delete") // 삭제        /   @PathVariable    @RequestParam
    @ResponseBody
    public Boolean deleteReview(@RequestParam("id") Long id) {
        campCommentService.deleteById(id);
        return true;
    }

}
