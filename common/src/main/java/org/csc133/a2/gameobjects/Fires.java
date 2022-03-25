package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.ArrayList;

public class Fires extends GameObjectCollection<Fire>{

    public Fires() {
        super();
        this.color = ColorUtil.rgb(255,0,0);
    }

    public boolean size() {
        if(this.getGameObjects().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        for(Fire fire : getGameObjects()) {
            if(fire.getCurrentState() == BurningFire.instance())
                fire.draw(g, containerOrigin);
        }
    }

}
