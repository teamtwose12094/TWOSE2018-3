package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 2/3/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Do Nothing", group = "Autonomous")
public class Nothing extends Autonomous {
    @Override
    public void runPath() {

     boolean flag = false;


    while (flag == false) {
        if (getOrientation() == "left") {
            pivot(45, 0.7);
            flag = true;
        } else if (getOrientation() == "center") {
            move(5, 0.7);
            flag = true;
        } else if (getOrientation() == "right") {
            pivot(45, -0.7);
            flag = true;
        }
    }


        //sleep(100000);

    }
}
