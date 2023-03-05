package camput.service;


import camput.dto.CategoryDto;
import camput.dto.MapCampDto;

import java.util.List;

public interface MapCampService {
    List<MapCampDto> findCamps();
    List<MapCampDto> categoryCamps(CategoryDto categoryDto);
    List<MapCampDto> searchCamp(String searchText);
    List<MapCampDto> bestFiveCamp();
    List<MapCampDto> findAll();
}
