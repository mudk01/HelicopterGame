package org.csc133.a2.views;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class GlassCockpit extends Container {
    GameWorld gw;
    Label heading;
    Label speed;
    Label fuel;
    public GlassCockpit(GameWorld gw) {
        this.gw = gw;
        this.setLayout(new GridLayout(2, 3));
        this.add("Heading");
        this.add("Speed");
        this.add("Fuel");

        heading = new Label("0");
        speed = new Label("0");
        fuel = new Label("0");

        this.add(heading);
        this.add(speed);
        this.add(fuel);
    }

    public void update() {
        heading.setText(gw.getHeading());
        speed.setText(gw.getSpeed());
        fuel.setText(gw.getFuel());

    }
}
