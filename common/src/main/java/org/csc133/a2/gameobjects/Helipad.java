package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

public class Helipad extends GameObject{
    private Point rectangleLocation, centerLocation;
    private int boxSize;
    private int circleSize, radius;

    public Helipad() {
        boxSize = 150;
        circleSize = 100;
        radius = circleSize/2;
        rectangleLocation = new Point(Game.DISP_W/2 - boxSize/2,
                (int) (Game.DISP_H - (boxSize*1.5)));
        centerLocation =
                new Point(rectangleLocation.getX() + (boxSize/2),
                        rectangleLocation.getY() + (boxSize/2));
    }

    void draw(Graphics g) {
        g.setColor(ColorUtil.GRAY);
        g.drawRect(rectangleLocation.getX(), rectangleLocation.getY(), boxSize,
                boxSize, 5);
        g.drawArc(centerLocation.getX() - radius,
                centerLocation.getY() - radius, circleSize,
                circleSize, 0, 360);
        g.setColor(ColorUtil.BLUE);
    }

    public Point getHelipadCenter() {
        return centerLocation;
    }

    public int getHelipadSize() {
        return circleSize;
    }


    @Override
    public void draw(Graphics g, Point containerOrigin) {
        draw(g);
    }
}
