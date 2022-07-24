package _20220724_UndergroundSystem;

import org.junit.Assert;
import org.junit.Test;

public class UndergroundSystemTest {

    private static final double DELTA = 0.00001;

    private UndergroundSystem undergroundSystem;

    @Test
    public void case1() {
        undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        Assert.assertEquals(14.0, undergroundSystem.getAverageTime("Paradise", "Cambridge"), DELTA);
        Assert.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), DELTA);

        undergroundSystem.checkIn(10, "Leyton", 24);
        Assert.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), DELTA);

        undergroundSystem.checkOut(10, "Waterloo", 38);
        Assert.assertEquals(12.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"), DELTA);
    }

    @Test
    public void case2() {
        undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        Assert.assertEquals(5.0, undergroundSystem.getAverageTime("Leyton", "Paradise"), DELTA);

        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        Assert.assertEquals(5.5, undergroundSystem.getAverageTime("Leyton", "Paradise"), DELTA);

        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        Assert.assertEquals(6.66667, undergroundSystem.getAverageTime("Leyton", "Paradise"), DELTA);
    }

}