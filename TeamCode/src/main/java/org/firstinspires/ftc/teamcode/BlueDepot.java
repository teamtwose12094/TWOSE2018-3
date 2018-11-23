package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "BlueDepot", group = "Autonomous")
public class BlueDepot extends Autonomous {
    @Override
    public void runPath() {
       // move(50, -0.7);
        //detectColor();
      //  pivot(180, 0.7);
        //move(50, 0.7);
        //pivot(-90, 0.7);
        //move(50, 0.7);
        move (50, -0.7);
        pivot(90,0.7);
        move(100, 0.7);
    }
}