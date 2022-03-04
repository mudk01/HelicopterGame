package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Drawable;

public abstract class GameObject implements Drawable {
    int color;
    Point location;
    Dimension dimension;
    Dimension worldSize;

    public String toString() {
        return this.getClass().getSimpleName();
    }
//
//    private Point location;
//    private Dimension dimension;
//    private int color;
//
//    public GameObject(Point location, Dimension dimension, int color) {
//        this.location = location;
//        this.dimension = dimension;
//        this.color = color;
//    }
//
//    public GameObject() {
//
//    }
//
//    void draw(Graphics g, Point centerOrigin) {
//
//    }

//    void setLocation(Point location) {
//        this.location = location;
//    }
//
//    void setDimension(Dimension dimension) {
//        this.dimension = dimension;
//    }
//
//    void setColor(int color) {
//        this.color = color;
//    }
//
//    public Point getLocation() {
//        return location;
//    }
//
//    public Dimension getDimension() {
//        return dimension;
//    }

}
// use Dimension to encapsulate width and heights of objects

