package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedDepot", group = "Autonomous")
public class RedDepot extends Autonomous {
    @Override
    public void runPath() {
        move (50, -0.7);
        pivot(90,0.7);
        move(100, 0.7);
    }
}