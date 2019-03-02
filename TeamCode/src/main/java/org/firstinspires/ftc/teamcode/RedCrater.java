package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 10/26/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "RedCrater", group = "Autonomous")
public class RedCrater extends Autonomous {

    @Override
    public void runPath() {

        int orientation = getOrientation();

       if (orientation == 1){
            pivot(40, 0.7);
            move(10, 0.7);
            pivot(150, -0.7); //the motors are seemingly not perfectly symmetrical
            move(122, 0.7);
            pivot(110, -0.7);
        }
        else if (orientation == 2){
            move(9, 0.7);
            pivot(115, -0.7);
            move (109, 0.7);
            pivot(110, -0.7);
        }
        else if (orientation == 3) {
           pivot(45, -0.7);
           move(10, 0.7);
           pivot(85, -0.7);
           move(97, 0.7);
           pivot(110, -0.7);
//            pivot(30, -0.7);
//            move(20, 0.7);
//            pivot(30, 0.7);
//            move (27, 0.7);
        }
        else {
            move (82, 0.7);
        }
//
//        if(getOrientation()== 1){
//            pivot(15, 0.7);
//            move(5, 0.7);
//        }
//        else if(getOrientation() == 2) {
//            move(5, 0.7);
//        }
       // else(getOrientation2()==);


        //move (27, 0.9);
        // closed(2, 0);
        // moveArm (1, 5);
       // release();
//        pivot(-135,0.9);
//        move(60, 0.9);
//        moveMarkerStick(50); //knockem over
//        pivot(-180, 0.9);
//        move (75, 0.9);
//        moveMarkerStick(-50); //knockem under



    }

}