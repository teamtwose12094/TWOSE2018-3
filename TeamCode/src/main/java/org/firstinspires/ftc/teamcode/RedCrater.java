package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedCrater", group = "Autonomous")
public class RedCrater extends Autonomous {
    @Override
    public void runPath() {
        move (25, 0.7);
        //knockem over
        pivot(-100,0.7);
        move(50, 0.7);
        pivot(-80, 0.7);
        move (50, 0.7);
        pivot(-180,0.7);
        move(50,0.7);

    }
}