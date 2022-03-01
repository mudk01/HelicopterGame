package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.Random;

public class Fire {
    private Point centerLocation;
    private int size, radius;
    private Font fireSizeFont;
    private boolean isDetected;

    public Fire(int fireSize, Point fireLocation) {
        size = fireSize;
        radius = fireSize/2;
        centerLocation = new Point(fireLocation.getX() + radius,
                fireLocation.getY() + radius);
        fireSizeFont = Font.createSystemFont(Font.FACE_SYSTEM,
                Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        isDetected = false;
    }

    void growFire() {
        int move = new Random().nextInt(2);
        size += move;
        radius = size/2;
        centerLocation.setX(centerLocation.getX() - (int)(move/2));
        centerLocation.setY(centerLocation.getY() - (int)(move/2));
    }

    void reduceFire(int water) {
        size -= water / (new Random().nextInt(7) + 8);
    }

    void draw(Graphics g) {
        g.setColor(ColorUtil.MAGENTA);
        g.setFont(fireSizeFont);

        if(size>0) {
            g.fillArc(centerLocation.getX() - radius,
                    centerLocation.getY() - radius, size, size,0,
                    360);
            g.drawString("" + size, centerLocation.getX() + radius,
                    centerLocation.getY() + radius);
        }
    }
}
