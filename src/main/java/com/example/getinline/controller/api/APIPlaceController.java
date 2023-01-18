package com.example.getinline.controller.api;

import com.example.getinline.constant.PlaceType;
import com.example.getinline.dto.APIDataResponse;
import com.example.getinline.dto.PlaceDTO;
import com.example.getinline.dto.PlaceRequest;
import com.example.getinline.dto.PlaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceResponse.of(
                1L,
                PlaceType.COMMON,
                "배드민턴장",
                "서울 강남구",
                "010-1234-5678",
                10,
                "신장개업"
        )));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/places")
    public APIDataResponse<Void> createPlace(@RequestBody PlaceRequest placeReuest) {
        return APIDataResponse.empty();
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceResponse> getPlace(@PathVariable Long placeId) {
        if(placeId.equals(2L)) {
            return APIDataResponse.empty();
        }
        return APIDataResponse.of(PlaceResponse.of(
                placeId,
                PlaceType.COMMON,
                "배드민턴장",
                "서울 강남구",
                "010-1234-5678",
                10,
                "신장개업"
        ));

    }

    @PutMapping("/places/{placeId}")
    public APIDataResponse<Void> modifyPlace(@PathVariable Long placeId, @RequestBody PlaceRequest placeRequest) {
        return APIDataResponse.empty();
    }

    @DeleteMapping("/places/{placeId}")
    public APIDataResponse<Void> removePlace(@PathVariable Long placeId) {
        return APIDataResponse.empty();
    }

}
