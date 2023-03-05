package camput.impl;

import camput.dto.loginApiDto.LoginSessionDto;
import camput.service.LoginCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginCheckImpl implements LoginCheckService {
    @Override
    public String checkLogin(HttpServletRequest request) {
        if(request.getSession().getAttribute("loginMember")!=null){
            HttpSession session = request.getSession();
            LoginSessionDto loginSessionDto =(LoginSessionDto) session.getAttribute("loginMember");
            String loginId = loginSessionDto.getLoginId();
            return loginId;
        }
       return null;
    }
}
