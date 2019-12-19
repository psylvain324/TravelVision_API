package com.travel.vision.restaurants;

import com.travel.vision.api.controllers.RoomChargeController;
import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.services.RoomChargeService;
import com.travel.vision.api.utilities.TvResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

public class RoomChargeControllerTest {
    @Mock
    RoomChargeService roomChargeService;
    RoomChargeController roomChargeController = new RoomChargeController(roomChargeService);
    RoomCharge roomCharge = null;

    @Before
    public void setup() {
        roomCharge = new RoomCharge();
        roomCharge.setId(1);
        roomCharge.setBillAmount(249.95);
        roomCharge.setEmail("test@junit.org");
        roomCharge.setLastName("Happy");
        roomCharge.setRoomNumber(123);
        roomCharge.setTaxRate(new BigDecimal("4.50"));
        BigDecimal taxAmount = roomCharge.getTaxRate().multiply(new BigDecimal(roomCharge.getBillAmount()));
        roomCharge.setTaxAmount(taxAmount.doubleValue());
        roomCharge.setTipAmount(50.05);
        roomCharge.setCreatedBy("TestUser");
        roomCharge.setCreatedDate(LocalDateTime.MIN);
        roomCharge.setLastModifiedBy("MockUser");
        roomCharge.setLastModifiedDate(LocalDateTime.MIN);
    }

    //TODO: Failure Paths

    @Test
    public void GetControllerHappyPath() {
        TvResponse<RoomCharge> actualResults = roomChargeController.getOneRoomCharge(roomCharge.getId());
        assertEquals(true, actualResults.isResult());
        actualResults.getData().setTotalAmount(roomChargeService.calculateBillTotal(
                roomCharge.getBillAmount(),
                roomCharge.getTaxRate().multiply(new BigDecimal(roomCharge.getBillAmount())),
                roomCharge.getTipAmount())
        );
        assertEquals(311.25, roomCharge.getTotalAmount());
    }
}
