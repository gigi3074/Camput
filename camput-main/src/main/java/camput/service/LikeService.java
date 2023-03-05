package camput.service;

import camput.dto.LikeDto;
import org.json.simple.parser.ParseException;

public interface LikeService {
    LikeDto like(String loginId, String campName) throws ParseException;

}
