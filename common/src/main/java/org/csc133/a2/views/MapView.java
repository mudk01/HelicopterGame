package org.csc133.a2.views;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.GameWorld;
import org.csc133.a2.gameobjects.GameObject;
import org.csc133.a2.interfaces.Drawable;

import static com.codename1.charts.compat.Paint.g;

public class MapView implements Drawable {
    private GameWorld gw;

    public MapView(GameWorld gw) {
        this.gw = gw;
        for(GameObject go: gw.getGameObjectCollection()) {
            go.draw(g, new Point(this.getX(), this.getY()));
        }
    }
//
//    void draw(Graphics g, Point centerOrigin) {
//        for(GameObject go: gw.getGameObjectCollection()) {
//            go.draw(g, new Point(this.getX(), this.getY()));
//        }
//    }
}
