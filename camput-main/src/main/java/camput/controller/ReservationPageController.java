package camput.controller;

import camput.dto.FinalReservationDto;
import camput.dto.MemberPointDto;
import camput.service.CamputService;
import camput.service.LoginCheckService;
import camput.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/camput")
@Slf4j
public class ReservationPageController {

    private final CamputService camputService;
    private final MemberService memberService;
    private final LoginCheckService loginCheckService;
    @GetMapping("/reservationPage")
    public String reservationPageForm(@Valid@ModelAttribute FinalReservationDto reserInfo,
                                      HttpServletRequest request, Model model,
                                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/camput/detail"+reserInfo.getCampName();
        }
        String loginId = loginCheckService.checkLogin(request);
        MemberPointDto point = memberService.memberPoint(loginId, reserInfo.getPrice());
        if(Integer.parseInt(point.getAfterMemberPoint())<0){
            model.addAttribute("noPoint","cant");
        }
        model.addAttribute("memberInfo",point);
        model.addAttribute("member",loginId);
        model.addAttribute("finalReservationInfo",reserInfo);
        return "reservation";
    }

    @PostMapping("/reservationPage/init")
    @ResponseBody
    public String booking(@RequestBody String reservationInfoList,HttpServletRequest request) throws ParseException {
        String loginId = loginCheckService.checkLogin(request);
        String result = camputService.bookedCamp(loginId, reservationInfoList);
    return result;
    }
}
