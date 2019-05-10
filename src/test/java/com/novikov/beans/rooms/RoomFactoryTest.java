package com.novikov.beans.rooms;

import com.novikov.beans.Room;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RoomFactoryTest extends TestCase {


    @Test
    public void testCreateRoomOk(){
        Room res = null;
        res = RoomFactory.createRoom(12,34);
        assertNotNull(res);
    }

}