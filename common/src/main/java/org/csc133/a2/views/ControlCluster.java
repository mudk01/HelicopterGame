package org.csc133.a2.views;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class ControlCluster extends Container {
    GameWorld gw;
    Button left, right, fight, exit, drink, brake, accelerate ;
    public ControlCluster(GameWorld gw) {
        this.gw = gw;

        this.getStyle().setBgColor(ColorUtil.rgb(255,255,255));
        this.getStyle().setBgTransparency(255);

        this.setLayout(new BorderLayout());

        left = new Button("Left");
        right = new Button("Right");
        fight = new Button("Fight");
        exit = new Button("Exit");
        drink = new Button("Drink");
        brake = new Button("Brake");
        accelerate = new Button("Accel");
        this.add(BorderLayout.WEST, left);
        this.add(BorderLayout.WEST, right);
        this.add(BorderLayout.WEST, fight);
        this.add(BorderLayout.CENTER, exit);
        this.add(BorderLayout.EAST, accelerate);


    }

}
