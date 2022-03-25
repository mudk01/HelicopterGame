package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;

public class River extends Fixed{
    private int x, y;
    private Point location;


    public River(Dimension worldSize) {
        this.color = ColorUtil.rgb(0,52,254);
        this.worldSize = worldSize;
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight()/9);
        location = new Point(0,
                worldSize.getHeight()/3-this.dimension.getHeight());

    }

    public Point getLocation() {
        return location;
    }

    public int getWidth() {
        return dimension.getWidth();
    }

    public int getHeight() {
        return dimension.getHeight();
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        x = location.getX();
        y = containerOrigin.getY() + location.getY()-dimension.getHeight();

        g.drawRect(x,y,dimension.getWidth(),dimension.getHeight(),5);
    }


}
