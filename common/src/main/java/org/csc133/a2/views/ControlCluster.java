package org.csc133.a2.views;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;
import org.csc133.a2.commands.*;

import javax.swing.border.Border;

public class ControlCluster extends Container {
    GameWorld gw;
    Button left, right, fight, exit, drink, brake, accelerate;
    Container leftCont, rightCont, exitCont;
    public ControlCluster(GameWorld gw) {
        this.gw = gw;
        this.setLayout(new BorderLayout());
        this.getStyle().setBgColor(ColorUtil.rgb(0,0,0));

        leftCont = new Container(new BorderLayout());
        leftCont.getStyle().setBgTransparency(255);
        rightCont = new Container(new BorderLayout());
        rightCont.getStyle().setBgTransparency(255);
        exitCont = new Container(new BorderLayout());
        exitCont.getStyle().setBgTransparency(255);

        left = new Button("Left");
        right = new Button("Right");
        fight = new Button("Fight");
        exit = new Button("Exit");
        drink = new Button("Drink");
        brake = new Button("Brake");
        accelerate = new Button("Accel");

        left.setCommand(new SteerLeftCommand(gw));
        right.setCommand(new SteerRightCommand(gw));
        fight.setCommand(new FightCommand(gw));
        exit.setCommand(new ExitCommand(gw));
        drink.setCommand(new DrinkCommand(gw));
        brake.setCommand(new DecelerateCommand(gw));
        accelerate.setCommand(new AccelerateCommand(gw));

        leftCont.add(BorderLayout.WEST, left);
        leftCont.add(BorderLayout.CENTER, right);
        leftCont.add(BorderLayout.EAST, fight);
        exitCont.add(BorderLayout.CENTER, exit);
        rightCont.add(BorderLayout.WEST, drink);
        rightCont.add(BorderLayout.CENTER, brake);
        rightCont.add(BorderLayout.EAST, accelerate);
        this.add(BorderLayout.WEST, leftCont);
        this.add(BorderLayout.CENTER, exitCont);
        this.add(BorderLayout.EAST, rightCont);

    }

}
