package com.example.getinline.controller.api;

import com.example.getinline.constant.PlaceType;
import com.example.getinline.dto.APIDataResponse;
import com.example.getinline.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceDTO.of(
                PlaceType.COMMON,
                "배드민턴장",
                "서울 강남구",
                "010-1234-5678",
                10,
                "신장개업"
        )));
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable Integer placeId) {
        if(placeId.equals(2)) {
            return APIDataResponse.of(null);
        }
        return APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "배드민턴장",
                "서울 강남구",
                "010-1234-5678",
                10,
                "신장개업"
        ));

    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) {
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId) {
        return true;
    }

}
