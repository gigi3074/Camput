package camput.service;

import camput.domain.MemberBooked;

public interface MemberBookedService {
    MemberBooked makeMemberReservation(Long campBookedId, String memberId);
}
