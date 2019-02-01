package org.firstinspires.ftc.teamcode;
/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedDepot", group = "Autonomous")
public class RedDepot extends Autonomous {
    @Override
    public void runPath() {


        move (10, -0.9);
        move (5, 0.9);
//        move (1, -0.7); //???
//        move (30, 0.7);
//        //moveMarkerStick(50);//knockem
//        move (5, -0.7);
//        pivot(95,-0.7);
//        move (65, 0.7);
//        //moveMarkerStick(-50);//close
    }
}