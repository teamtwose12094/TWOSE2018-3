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
            move(5, 0.7);
            pivot(40, 0.7);
            move(20, 0.7);
            pivot(50,-0.7);
            move(20, 0.7);

        }
        else if (orientation == 2){
            move(45, 0.7);
        }
        else if (orientation == 3) {
            move(5, 0.7);
            pivot(40, -0.7);
            move(20, 0.7);
            pivot(50,0.7);
            move(20, 0.7);
//            pivot(30, -0.7);
//            move(20, 0.7);
//            pivot(30, 0.7);
//            move (27, 0.7);
        }
        else {
            move (27, 0.7);
        }
//        move(10, -0.7);
//        pivot(45,-0.7);
//        move(30,-0.7);


//        move (30, 0.7);
//        //moveMarkerStick(50);//knockem
//        move (-5, -0.7);
//        pivot(95,-0.7);
//        move(65, 0.7);
//        //moveMarkerStick(-50);//close
    }
}