package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;

public class River extends GameObject{
    private int width, height, x, y;
    private Point location;


    public River(Dimension worldSize) {
        this.color = ColorUtil.rgb(0,52,254);
        this.worldSize = worldSize;
        location = new Point(0, worldSize.getHeight()/3);
        System.err.println(worldSize.getHeight()/3);
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight());
        width = dimension.getWidth();
        height = dimension.getHeight()/9;

    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        x = containerOrigin.getX() + location.getX();
        y = containerOrigin.getY() + location.getY()-height;

        g.drawRect(x,y,width,height,5);
    }


}
