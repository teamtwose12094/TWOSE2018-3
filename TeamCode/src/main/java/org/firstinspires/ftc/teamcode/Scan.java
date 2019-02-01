package org.firstinspires.ftc.teamcode;

/**
 * Created by student on 2/3/2017.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Scan", group = "Autonomous")
public class Scan extends Autonomous {
    @Override
    public void runPath() {

        boolean flag = false;
        boolean left = true;
        int counter = 0;


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
            } else if (getOrientation() == "insufficient"){

                if (counter < 30){
                    if (left == true) {
                        pivot(1, 0.5);
                        counter = counter + 1;
                    }
                    else{
                        pivot (-1, 0.5);
                        counter = counter + 1;
                    }
                }
                else {
                    counter = 0;
                    left = !left;
                }

            }
        }


        //sleep(100000);

    }
}
