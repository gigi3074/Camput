package camput.service;


import camput.dto.MemberJoinDto;

//@Service
//@RequiredArgsConstructor
public interface JoinService {

    void join(MemberJoinDto memberJoinDto);
    void validateDuplicateMember(MemberJoinDto memberJoinDto);

    public String memberLoginCheck(String memberEmail);

}
