package camput.service;

import camput.dto.MemberJoinDto;

public interface MemberUpdateService {

    MemberJoinDto view(String loginId);
    String update(MemberJoinDto memberJoinDto);
}
