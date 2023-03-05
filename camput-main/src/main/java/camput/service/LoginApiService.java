package camput.service;

import camput.dto.loginApiDto.MemberResponseDto;
import camput.dto.loginApiDto.SocialAuthResponse;


public interface LoginApiService {
    SocialAuthResponse getAccessToken(String code);
    MemberResponseDto getUserInfo(String token);
    void logOut(String code);

}



