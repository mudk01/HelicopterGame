package org.csc133.a2.gameobjects;

abstract class Moveable extends GameObject {
    int speed;
    int heading;

    public Moveable() {
        super();
    }

    public void move() {
    }

    public int getSpeed() {
        return speed;
    }

    public int getHeadingAngle(int head) {
        if(heading < 0) {
            heading += 360;
        }
        if(heading >= 360) {
            heading -= 360;
        }

        return heading;
    }
}
