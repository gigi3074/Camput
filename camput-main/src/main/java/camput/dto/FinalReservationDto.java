package camput.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class FinalReservationDto {

    @NotEmpty
    private String campName;
    @NotEmpty
    private String campAddress;
    @NotEmpty
    private String price;
    @NotEmpty
    private String startReservationDay;
    @NotEmpty
    private String endReservationDay;

    @Builder
    public FinalReservationDto(String campName, String campAddress, String price, String startReservationDay, String endReservationDay) {
        this.campName = campName;
        this.campAddress = campAddress;
        this.price = price;
        this.startReservationDay = startReservationDay;
        this.endReservationDay = endReservationDay;
    }
}
