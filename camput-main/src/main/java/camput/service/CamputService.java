package camput.service;

import camput.dto.DetailPageDto;
import camput.domain.Camput;
import org.json.simple.parser.ParseException;

public interface CamputService {
    DetailPageDto show(String campName,String memberLoginId);
    String bookedCamp(String loginId, String reservationInfoList) throws ParseException;

    Camput findByCampName(String campName);

}
