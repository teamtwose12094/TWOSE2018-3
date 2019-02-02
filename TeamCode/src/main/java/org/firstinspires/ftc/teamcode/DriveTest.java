package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "THE MOST SAVAGE DANCE MOVES IN THE WHOLE WORLD", group = "Autonomous")
public class DriveTest extends Autonomous {
    @Override
    public void runPath() {

        move(5,-0.9);
        pivot(30,-0.9);
        pivot(-30, -0.9);
//        move(1, -0.5);
//        move(1,  -0.75);
//        move(1, -1.0);
    }
}
