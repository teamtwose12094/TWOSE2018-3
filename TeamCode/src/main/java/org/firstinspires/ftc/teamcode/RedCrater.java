package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedCrater", group = "Autonomous")
public class RedCrater extends Autonomous {
    @Override
    public void runPath() {
        move (10, 0.9);
        //knockem over
        pivot(-100,0.9);
        move(10, 0.9);
        pivot(-80, 0.9);
        move (10, 0.9);
        pivot(-180,0.9);
        move(10,0.9);


    }
}