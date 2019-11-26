package com.travel.vision.api.controllers;

import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.services.RoomChargeService;
import com.travel.vision.api.utilities.ResponseDtoConverter;
import com.travel.vision.api.utilities.TvResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/room-charge/")
@Api(value = "User Profile API")
public class RoomChargeController {
    private final RoomChargeService roomChargeService;

    public RoomChargeController(RoomChargeService roomChargeService) {
        this.roomChargeService = roomChargeService;
    }

    @ApiOperation(value = "Create a new Room Charge record")
    @PostMapping(value = "/create/")
    public TvResponse<String> createRoomCharge (@Valid @RequestBody RoomCharge roomCharge) {
        roomChargeService.create(roomCharge);
        return ResponseDtoConverter.convert(Message.ROOM_CHARGE_ADDED);
    }

    @ApiOperation(value = "Update an already created Room Charge")
    @PatchMapping(value = "/update/")
    public TvResponse<String> updateRoomCharge (@Valid @RequestBody RoomCharge roomCharge) {
        roomChargeService.update(roomCharge);
        return ResponseDtoConverter.convert(Message.ROOM_CHARGE_UPDATED);
    }

    @ApiOperation(value = "Delete a Room Charge by Id")
    @DeleteMapping(value = "/delete/{roomChargeId}")
    public TvResponse<String> deleteRoomCharge(@PathVariable("roomChargeId") String roomChargeId) {
        roomChargeService.delete(roomChargeId);
        return ResponseDtoConverter.convert(Message.ROOM_CHARGE_DELETED);
    }

    @ApiOperation(value = "Get List of Room Charge records")
    @GetMapping(value = "/room-charges/")
    public TvResponse<List<RoomCharge>> getAllRoomCharges() {
        return ResponseDtoConverter.convert(roomChargeService.findAll());
    }

    @ApiOperation(value = "Get a single Room Charge record by Id")
    @GetMapping(value = "/room-charges/{roomChargeId}")
    public TvResponse<RoomCharge> getOneRoomCharge(@PathVariable String roomChargeId) {
        return ResponseDtoConverter.convert(roomChargeService.getOne(roomChargeId));
    }

    private static class Message {
        private final static String ROOM_CHARGE_ADDED = "Room Charge added successfully";
        private final static String ROOM_CHARGE_UPDATED = "Room Charge updated successfully";
        private final static String ROOM_CHARGE_DELETED = "Room Charge deleted successfully";
    }
}
