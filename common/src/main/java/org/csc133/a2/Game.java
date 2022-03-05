package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.views.MapView;
import org.csc133.a2.views.GlassCockpit;


public class Game extends Form implements Runnable {
    private GameWorld gw;
    MapView mapView;
    GlassCockpit glassCockpit;

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
        setTitle("A2 Game");

        mapView = new MapView(gw);
        glassCockpit = new GlassCockpit(gw);


        addKeyListener(-92, (evt) -> gw.input(-92));
        addKeyListener(-91, (evt) -> gw.input(-91));
        addKeyListener(-94, (evt) -> gw.input(-94));
        addKeyListener(-93, (evt) -> gw.input(-93));
        addKeyListener('d', (evt) -> gw.input('d'));
        addKeyListener('f', (evt) -> gw.input('f'));

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, glassCockpit);
        this.add(BorderLayout.CENTER, mapView);

        UITimer timer = new UITimer(this);
        timer.schedule(50, true, this);

        this.getAllStyles().setBgColor(ColorUtil.rgb(0, 0, 0));
        this.show();
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void run() {
        gw.tick();
        glassCockpit.update();
        repaint();
    }
}
