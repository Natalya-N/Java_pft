package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testDistanceWithSamePoint(){
        Point p1 = new Point(3,5);
        Assert.assertEquals(p1.distance(p1), 0.0);
    }

    @Test
    public void testDistance(){
        Point p1 = new Point(7,9);
        Point p2 = new Point(10,4);
        Assert.assertEquals(p1.distance(p2), 5.830951894845301);
    }

    @Test
    public void testDistanceWithZeroPoint(){
        Point p1 = new Point(7,9);
        Point p2 = new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 11.40175425099138);
    }
}
