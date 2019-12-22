package com.travel.vision.restaurants;

import com.travel.vision.api.models.restaurants.RoomCharge;
import com.travel.vision.api.services.RoomChargeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RoomChargeTests {
    @Mock
    RoomChargeService roomChargeService;
    @Mock
    RoomCharge roomCharge;

    @Before
    public void setUp() {

    }

    @Test
    public void sanity() {
        assertNotNull(roomCharge);
    }
}
