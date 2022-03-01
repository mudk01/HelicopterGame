package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Steerable;

public class Helicopter extends Moveable implements Steerable {
    private int size, hRadius, centerX, centerY, currSpeed, fuel, water;
    private Point helipadCenterLocation, heliLocation;
    private int endHeadX, endHeadY, padSize;
    private double angle;
    private final int MAX_SPEED = 10;
    private boolean riverCollision;

    public Helicopter(Point heliCenter, int helipadSize) {
        size = 30;
        currSpeed = 0;
        fuel = 0;
        water = 0;
        helipadCenterLocation = heliCenter;
        hRadius = size/2;
        heliLocation = new Point(helipadCenterLocation.getX() - hRadius,
                helipadCenterLocation.getY());
        centerX = heliLocation.getX() + hRadius;
        centerY = heliLocation.getY() + hRadius;
        angle = Math.toRadians(90);
        endHeadX = centerX;
        endHeadY = centerY - (size*2);
        riverCollision = false;
        padSize = helipadSize;
    }

     void move(){
        heliLocation.setY((int) (heliLocation.getY() - Math.sin(angle) *
                currSpeed));
        centerY = heliLocation.getY() + hRadius;
        heliLocation.setX((int) (heliLocation.getX() + Math.cos(angle) *
                currSpeed));
        centerX = heliLocation.getX() + hRadius;
        endHeadX = (int) (centerX + Math.cos(angle) * size*2);
        endHeadY = (int) (centerY - Math.sin(angle) * size*2);
        fuel -= (int) (Math.sqrt(currSpeed) + 5);
    }

    void draw(Graphics g) {
        g.setColor(ColorUtil.YELLOW);
        g.fillArc(heliLocation.getX(),
                heliLocation.getY(), size,
                size, 0, 360);
        g.drawLine(centerX, centerY, endHeadX,
                endHeadY);
        g.drawString("F: " + fuel, heliLocation.getX(),
                heliLocation.getY() + (size*3));
        g.drawString("W: " + water ,heliLocation.getX(),
                heliLocation.getY() + (size*4));
    }

    @Override
    public void steerLeft() {

    }

    @Override
    public void steerRight() {

    }
}
