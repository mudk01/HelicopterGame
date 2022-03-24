package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

import java.util.Random;

public class Building extends Fixed{
    private Point location;
    private Dimension dimension;
    private int value, damage;

    public Building(Dimension worldSize, Point loc, Dimension dimensions) {
        this.color = ColorUtil.rgb(255,0,0);
        this.worldSize = worldSize;
        dimension = new Dimension(dimensions.getWidth(),
                dimensions.getHeight());
        this.location = new Point(loc.getX(), loc.getY());
        value = new Random().nextInt(1000) + 100;
    }


    public void setFireInBuilding(Fire fire) {
//        Point newFire =
//                new Point(new Random().nextInt(location.getX()) +
//                        dimension.getWidth(),
//                        new Random().nextInt(location.getY()) +
//                                dimension.getHeight());
        System.err.println("locationX: " + location.getX() + " dimW: " + dimension.getWidth() + " total=" + (location.getX()+dimension.getWidth()));
        System.err.println("locationY: " + location.getY() + " dimW: " + dimension.getHeight() + " total=" + (location.getY()+dimension.getHeight()));
//        fire.setLocation(newFire);
        fire.update();
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        int xInfoOffset = 10;
        g.setColor(color);
        g.drawRect(containerOrigin.getX() + location.getX(),
                containerOrigin.getY() + location.getY(),
                dimension.getWidth(), dimension.getHeight(), 5);
        g.drawString("V: " + value,
                location.getX() + dimension.getWidth() + xInfoOffset,
                containerOrigin.getY() + location.getY() + dimension.getHeight() - worldSize.getHeight()/15);
        g.drawString("D: " + damage,
                location.getX() + dimension.getWidth() + xInfoOffset,
                containerOrigin.getY() + location.getY() + dimension.getHeight() - worldSize.getHeight()/32);
    }
}
