package camput.service;

import camput.dto.MyPageCampDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyPageLikeService {
     Page<MyPageCampDto> likeCamps(String memberId, Pageable pageable);
}
