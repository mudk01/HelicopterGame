package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.Game;

public class River extends Fixed{
    private Point location;
    private int width;
    private int height;

    public River() {
        super();
        width = Game.DISP_W;
        height = Display.getInstance().getDisplayHeight()/9;
        location = new Point(0, Display.getInstance().getDisplayHeight()/3-height);

    }

    void draw(Graphics g, Point containerOrigin) {
        g.setColor(ColorUtil.BLUE);
        g.drawRect(containerOrigin.getX(),containerOrigin.getY(), width, height, 5);
    }
}
