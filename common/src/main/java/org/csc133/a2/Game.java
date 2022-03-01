package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable {
    private GameWorld gw;

    public final static int DISP_W = Display.getInstance().getDisplayWidth();
    public final static int DISP_H = Display.getInstance().getDisplayHeight();

    public static int getSmallDim() {
        return Math.min(DISP_W, DISP_H);
    }

    public static int getLargeDim() {
        return Math.max(DISP_W, DISP_H);
    }

    public Game() {
        gw = new GameWorld();

        UITimer timer = new UITimer(this);
        timer.schedule(50, true, this);

        this.getAllStyles().setBgColor(ColorUtil.rgb(0, 0, 0));
        this.show();
    }

    public void paint(Graphics g) {
        super.paint(g);
//        gw.draw(g);
    }

    @Override
    public void run() {
        gw.tick();
        repaint();
    }
}
