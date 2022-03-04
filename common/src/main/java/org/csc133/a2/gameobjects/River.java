package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

import java.awt.*;

public class River extends GameObject{
//    private Point location;
//    private int width;
//    private int height;

    public River(Dimension worldSize) {
        this.color = ColorUtil.BLUE;
        this.worldSize = worldSize;
        this.location = new Point(0, worldSize.getHeight()/3);
        this.dimension = new Dimension(worldSize.getWidth(),
                worldSize.getHeight());
        System.err.println(worldSize);
//        width = Game.DISP_W;
//        height = Display.getInstance().getDisplayHeight()/9;
//        location = new Point(0, Display.getInstance().getDisplayHeight()/3-height);

    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = containerOrigin.getX() + location.getX();
        int y = containerOrigin.getY() + location.getY();
        int h = dimension.getWidth();
        int w = dimension.getHeight()/9;
        g.drawRect(x,y,w,h,5);

//        draw(g);
    }


}
