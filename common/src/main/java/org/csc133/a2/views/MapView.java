package org.csc133.a2.views;

import com.codename1.ui.geom.Point;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;

public class MapView {

    public MapView(GameWorld gw) {
        for(GameObject go: gw.getGameObjectCollection()) {
            go.draw(g, new Point(this.getX(), this.getY()));
        }
    }
}
