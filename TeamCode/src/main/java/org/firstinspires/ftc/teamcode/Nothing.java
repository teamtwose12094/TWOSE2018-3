package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 2/3/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Do Nothing", group = "Autonomous")
public class Nothing extends Autonomous {
    @Override
    public void runPath() {

        final int MAX_ANGLE = 90;

        boolean flag = false;
        int angle = 0;
        int orientation = -1;

        while (orientation == -1){
            orientation = getOrientation();
        }

        while (((flag == false) && (angle <= MAX_ANGLE) && opModeIsActive())) {
            if (getOrientation() == 1) {
                pivot(-45, 0.7);
                move(5, 0.7);
                flag = true;
            } else if (getOrientation() == 2) {
                move(5, 0.7);
                flag = true;
            } else if (getOrientation() == 3) {
                pivot(45, 0.7);
                move(5, 0.7);
                flag = true;
            } else {
                pivot(1, 0.5);
                angle += 1;
            }
            //}


            //sleep(100000);

        }
    }
}
