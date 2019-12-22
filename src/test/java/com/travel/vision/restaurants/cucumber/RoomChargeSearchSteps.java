package com.travel.vision.restaurants.cucumber;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.services.RoomChargeService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomChargeSearchSteps {
    @Autowired
    RoomChargeService roomChargeService;
    List<RoomCharge> result = new ArrayList<>();
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
        roomCharge.setChargeDate(LocalDateTime.now());
    }

    @Given(".+room charge with the room number '(.+)' and last name '.+'")
    public void addNewBook(final int roomNumber, final String lastName) {
        roomCharge.setRoomNumber(roomNumber);
        roomCharge.setLastName(lastName);
        roomChargeService.create(roomCharge);
    }

    @When("^the user searches for room charges between (\\d+) and (\\d+)$")
    public void setSearchParameters(LocalDateTime from, LocalDateTime to) {
        result = roomChargeService.findAllByDate(from, to);
    }

    @Then("(\\d+) room charges should have been found$")
    public void verifyAmountOfRoomChargesFound(int chargesFound) {
        assertEquals(result.size(), chargesFound);
    }

    @Then("Room Charge (\\d+) should have the room number '(.+)'$ and last name '(.+)'$")
    public void verifyBookAtPosition(int position, String roomNumber, String lastName) {
        assertEquals(result.get(position - 1).getRoomNumber(), roomNumber);
        assertEquals(result.get(position - 1).getLastName(), lastName);
    }
}