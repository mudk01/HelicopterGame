package org.csc133.a2.gameobjects;

abstract class Moveable extends GameObject {
    int speed;
    int heading;

    public Moveable() {
        super();
    }

    public void move() {
    }

    public int getHeading(double angle) {
        this.heading = (int)(Math.round(Math.toDegrees(angle)));
        if(heading < 0) {
            heading += 360;
        }
        else if(heading >= 360) {
            heading -= 360;
        }

        return heading;
    }

    public abstract int getHeading();
}
