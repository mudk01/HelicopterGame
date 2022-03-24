package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

import java.util.Random;

public class Fire extends Fixed {
    private Point centerLocation;
    private int size, radius;
    private Font fireSizeFont;
    private boolean isDetected;
    private FireState currentState;

    private static Fire fire = new Fire();

    public Fire() {}

    public Fire(Dimension worldSize, Building b) {
        this.color = ColorUtil.rgb(255, 4, 252);
        this.worldSize = worldSize;
        this.dimension = new Dimension(this.worldSize.getWidth(),
                this.worldSize.getHeight());
        size = new Random().nextInt(10) + 30;
        radius = size/2;
        fireSizeFont = Font.createSystemFont(Font.FACE_SYSTEM,
                Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        isDetected = false;
        this.currentState = UnStartedFire.instance();
        System.err.println("In the fire class: " + currentState);
        b.setFireInBuilding(this);
    }

    public void setTrue() {
        isDetected = true;
    }

    public void setFalse() {
        isDetected = false;
    }

    public boolean detected() {
        return isDetected;
    }

    public void growFire() {
        int move = new Random().nextInt(2);
        size += move;
        radius = size/2;
        centerLocation.setX(centerLocation.getX() - (int)(move/2));
        centerLocation.setY(centerLocation.getY() - (int)(move/2));
    }

    public Point getFireLocation() {
        return centerLocation;
    }

    public int getRadius() {
        return radius;
    }

    public int getSize() {
        return size;
    }

    void reduceFire(int water) {
        size -= water / (new Random().nextInt(7) + 8);
    }

    public void setLocation(Point buildingLocation) {
        centerLocation = new Point((buildingLocation.getX() + radius),
                (buildingLocation.getY() + radius));
//        centerLocation.setX(buildingLocation.getX() + radius);
//        centerLocation.setY(buildingLocation.getY() + radius);
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.setFont(fireSizeFont);
        g.fillArc(centerLocation.getX()-radius,
                containerOrigin.getY() + centerLocation.getY() - radius, size,
                size, 0, 360);
        g.drawString("" + size, centerLocation.getX() + radius,
                containerOrigin.getY() + centerLocation.getY() + radius);
    }

    public void setCurrentState(FireState state) {
        this.currentState = state;
    }

    public FireState getCurrentState() {
        return currentState;
    }

    public void update() {
        this.currentState.updateState(this);
    }

    public void start() {
        update();
    }

}
