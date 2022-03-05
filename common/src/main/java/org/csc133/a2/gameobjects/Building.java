package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

public class Building extends GameObject{
    private Point location;
    private Dimension dimension;
    private int value, damage;

    public Building(Dimension worldSize, Point loc, Dimension dimensions) {
        this.color = ColorUtil.rgb(255,0,0);
        this.worldSize = worldSize;
        dimension = new Dimension(dimensions.getWidth(),
                dimensions.getHeight());
        this.location = new Point(loc.getX(), loc.getY());
    }


    void setFireInBuilding(Fire fire) {

    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        g.drawRect(containerOrigin.getX() + location.getX(),
                containerOrigin.getY() + location.getY(),
                dimension.getWidth(), dimension.getHeight(), 5);
    }
}
