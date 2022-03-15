package org.csc133.a2.commands;

import com.codename1.ui.Command;
import org.csc133.a2.GameWorld;

import java.awt.event.ActionEvent;

public class SteerRightCommand extends Command {
    private GameWorld gw;

    public SteerRightCommand(GameWorld gw) {
        super("Steer Right");
        this.gw = gw;
    }

    public void actionPerformed(ActionEvent event) {
    }
}
