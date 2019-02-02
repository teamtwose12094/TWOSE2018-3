package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 1/20/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "PivotTest", group = "Autonomous")
public class PivotTest extends Autonomous {
    @Override
    public void runPath() {
        pivot(45, 1.0);
        pivot(45, -1.0);
        move(5, 1.0);
        move(5, -1.0);
        move(0.5, -1.0);
//        pivot(45, 0.5);
//        sleep(5000);
//        pivot(-90, 0.5);
//        sleep(5000);
//        pivot(90, 0.5);
//        sleep(5000);
//        pivot(-180, 0.5);
//        sleep(5000);
////        pivot(360, 0.5);
        //spin(10000,0.45);

    }

}


