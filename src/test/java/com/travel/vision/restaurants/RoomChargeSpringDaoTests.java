package com.travel.vision.restaurants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.travel.vision.api.daos.restaurants.RoomChargeSpringDao;
import com.travel.vision.api.models.restaurants.RoomCharge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(value = MockitoJUnitRunner.class)
public class RoomChargeSpringDaoTests {
    @Mock
    JdbcTemplate mockJdbcTemplate;
    RoomChargeSpringDao springDao;

    @Before
    public void init() {
        springDao = new RoomChargeSpringDao(mockJdbcTemplate);
    }

    @Test
    public void createRoomCharge() {
        final long testRoomId = 12345;
        final int testRoomNumber = 01;
        final String testLastName = "Doe";

        RoomCharge roomOneDinner = new RoomCharge();
        roomOneDinner.setId(testRoomId);
        roomOneDinner.setRoomNumber(testRoomNumber);
        roomOneDinner.setLastName(testLastName);

        when(mockJdbcTemplate.update(anyString(), anyObject(), anyObject(),
                        anyObject())).thenReturn(1);

        assertTrue(springDao.create(roomOneDinner));
        ArgumentCaptor<Object> varArgs = ArgumentCaptor.forClass(Object.class);
        ArgumentCaptor<String> strArg = ArgumentCaptor.forClass(String.class);

        verify(mockJdbcTemplate).update(strArg.capture(), varArgs.capture(),
                varArgs.capture(), varArgs.capture());
        assertEquals(testRoomId, varArgs.getAllValues().get(0));
        assertEquals(testRoomNumber, varArgs.getAllValues().get(1));
        assertEquals(testLastName, varArgs.getAllValues().get(2));
    }

}

