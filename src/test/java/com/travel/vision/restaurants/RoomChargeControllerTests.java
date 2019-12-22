package com.travel.vision.restaurants;

import com.travel.vision.api.controllers.RoomChargeController;
import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.services.RoomChargeService;
import com.travel.vision.api.utilities.TvResponse;
import com.travel.vision.config.MockitoExtension;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@ExtendWith(MockitoExtension.class)
public class RoomChargeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private RoomChargeService roomChargeServiceMock;
    @InjectMocks
    private RoomChargeController roomChargeController;
    @Captor
    private ArgumentCaptor<RoomCharge> argCaptor;
    private RoomCharge roomCharge = null;

    @Before
    public void setup() {
        roomCharge = new RoomCharge();
        roomCharge.setId(12345);
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

    @Test
    public void RoomChargeReturns200AndLastName() {
        when().
                get("/room-charge/{id}", 12345).
                then().
                statusCode(200).
                body("RoomCharge.id", equalTo(5),
                        "RoomCharge.LastName", hasValue("Happy"));
    }

    @Test
    public void CalculateTotalHappyPath() {
        roomChargeController = new RoomChargeController(roomChargeServiceMock);
        roomCharge.setTotalAmount(roomChargeServiceMock.calculateBillTotal(
                roomCharge.getBillAmount(),
                roomCharge.getTaxRate().multiply(new BigDecimal(roomCharge.getBillAmount())),
                roomCharge.getTipAmount())
        );
        assertSame(311.25, roomCharge.getTotalAmount());
    }

    @Test
    public void ControllerHappyPath(Pageable pageable) {
        roomChargeController = new RoomChargeController(roomChargeServiceMock);
        roomCharge.setTotalAmount(311.25);
        //Create
        TvResponse<String> createResults = roomChargeController.createRoomCharge(roomCharge);
        assertEquals(true, createResults.isResult());
        assertSame("Room Charge added successfully", createResults.getData());
        roomCharge.setId(6789);
        roomChargeController.createRoomCharge(roomCharge);
        assertEquals(true, createResults.isResult());
        assertSame("Room Charge added successfully", createResults.getData());

        //Read
        TvResponse<RoomCharge> readResults = roomChargeController.getOneRoomCharge(roomCharge.getId());
        assertEquals(true, readResults.isResult());
        assertSame(readResults.getData(), roomCharge);
        TvResponse<Page<RoomCharge>> readAllResults = roomChargeController.getAllRoomCharges(pageable);
        assertEquals(true, readAllResults.isResult());
        assertSame(readAllResults.getData().getSize(), 2);

        //Update
        roomCharge.setRoomNumber(6789);
        TvResponse<String> updateResults = roomChargeController.updateRoomCharge(roomCharge);
        assertEquals(true, updateResults.isResult());
        assertSame("Room Charge updated successfully", updateResults.getData());
        readResults = roomChargeController.getOneRoomCharge(roomCharge.getId());
        assertEquals(true, createResults.isResult());
        assertSame(readResults.getData(), roomCharge);
        assertSame(6789, roomCharge.getRoomNumber());

        //Delete
        TvResponse<String> deleteResults = roomChargeController.deleteRoomCharge(roomCharge.getId());
        assertEquals(true, deleteResults.isResult());
        assertSame("Room Charge deleted successfully", deleteResults.getData());
        readResults = roomChargeController.getOneRoomCharge(roomCharge.getId());
        assertEquals(false, readResults.isResult());
    }
}
