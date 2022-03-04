package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;

public class River extends GameObject{

    public River(Dimension worldSize) {
        this.color = ColorUtil.BLUE;
        this.worldSize = worldSize;
        this.location = new Point(0, worldSize.getHeight()/3);
        System.err.println(worldSize.getHeight()/3);
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight());
        System.err.println(worldSize);

    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = containerOrigin.getX() + location.getX();
        int y = containerOrigin.getY() + location.getY();
        int h = dimension.getHeight()/9;
        int w = dimension.getWidth();
        g.drawRect(x,y-h,w,h,5);

//        draw(g);
    }


}
