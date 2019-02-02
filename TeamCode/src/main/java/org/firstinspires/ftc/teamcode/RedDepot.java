package org.firstinspires.ftc.teamcode;
/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedDepot", group = "Autonomous")
public class RedDepot extends Autonomous {
    @Override
   public void runPath() {

        int orientation = getOrientation();

        if (orientation == 1){
            move (10, -0.7);

        }
        else if (orientation == 2){
            pivot(10, -0.7);
            move (10, 0.7);
        }
        else if (orientation == 3) {
            pivot(20, -0.7);
            move(10, 0.7);
        }
        else if (orientation == 10){
            pivot(20, -0.7);
            pivot (-20, 0.7);
        }
        else {
            pivot (360, 0.7);
        }
//        move(0.5, -0.7);
//        move (30, 0.7);
//        //moveMarkerStick(50);//knockem
//        move (-5, -0.7);
//        pivot(95,-0.7);
//        move(65, 0.7);
//        //moveMarkerStick(-50);//close
    }
}