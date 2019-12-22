package com.travel.vision.restaurants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.travel.vision.api.daos.restaurants.RoomChargeDao;
import com.travel.vision.api.daos.restaurants.RoomChargeDaoImpl;
import com.travel.vision.api.database.DatabaseManager;
import com.travel.vision.api.models.restaurants.RoomCharge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(value = MockitoJUnitRunner.class)
public class RoomChargeDaoTests {
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockStatement;
    @Mock
    ResultSet mockResultSet;
    @Mock
    DatabaseManager databaseManager;
    RoomChargeDao dao;

    @Before
    public void setUp() {
        dao = new TestableRoomChargeDao(databaseManager);
    }

    @Test
    public void createMockRoomCharge() throws Exception {
        RoomCharge testRoomCharge = new RoomCharge();
        testRoomCharge.setId(12345);
        testRoomCharge.setRoomNumber(12);
        testRoomCharge.setLastName("Smith");

        when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);

        boolean succeed = dao.create(testRoomCharge);
        assertTrue(succeed);

        ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor
                .forClass(String.class);
        ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor
                .forClass(Integer.class);
        verify(mockStatement, new Times(3)).setString(intArgCaptor.capture(),
                stringArgCaptor.capture());

        assertEquals("12345", stringArgCaptor.getAllValues().get(0));
        assertEquals("12", stringArgCaptor.getAllValues().get(1));
        assertEquals("Smith", stringArgCaptor.getAllValues().get(2));

        verify(mockConn).prepareStatement(stringArgCaptor.capture());
        assertEquals(RoomChargeDaoImpl.INSERT_INTO_ROOM_CHARGE_VALUES,
                stringArgCaptor.getValue());

        verify(mockStatement).executeUpdate();
        verify(mockConn).commit();
        verify(mockStatement).close();
        verify(mockConn).close();
    }

    @Test
    public void retrieveMockRoomCharge() throws Exception {
        when(mockConn.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);

        when(mockResultSet.getLong("id")).thenReturn((long) 12345);
        when(mockResultSet.getInt("room_number")).thenReturn(12);
        when(mockResultSet.getString("last_name")).thenReturn("123");

        List<RoomCharge> roomCharges = dao.searchById(12345);

        assertEquals(1, roomCharges.size());
        RoomCharge testRoomCharge = roomCharges.get(0);

        assertEquals(12345, testRoomCharge.getId());
        assertEquals(12, testRoomCharge.getRoomNumber());
        assertEquals("Smith", testRoomCharge.getLastName());

        verify(mockResultSet).close();
        verify(mockStatement).close();
        verify(mockConn).close();
    }

    class TestableRoomChargeDao extends RoomChargeDaoImpl {
        public TestableRoomChargeDao(DatabaseManager databaseManager) {
            super(databaseManager);
        }

        protected Connection getConnection() {
            return mockConn;
        }
    }
}

