package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

//import static org.firstinspires.ftc.teamcode.HardwareK9bot.COLOURSTICK_HOME;

/**
 * Created by student on 11/24/2016.
 */
//comment/

public abstract class Autonomous extends LinearOpMode {

    protected HardwareK9bot robot = new HardwareK9bot();

    private int delay;
    private static int TICKS_PER_REVOLUTION = 1440;
    private static double GEAR_RATIO = 0.48; //used to be 0.5
    private static double WHEEL_BASE = 15.3; //used to be 8.0
    private static double TICKS_PER_INCH = TICKS_PER_REVOLUTION * GEAR_RATIO / (Math.PI * 4);

    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";
    private static final String VUFORIA_KEY = "ATz1+9P/////AAABmeqS5/62ZUGpp5bTjFOlpkUQ/xkdYMvOFM8cjbv7n7uq3sYzUf93tbck4Wwz4tLtprq66GBhDQn1s06gkPiK4MJqUHZsdytuNcFacZO/2S66hK08CjwewQE8Wqs1T8I3wIEQENcMkWha0xwyR/2JfDGwQEGPnO56etL1eXzhScwqGARW1kOAS/zSzg4aWBUITk5FvDZG3lMxpZWIFEOmCIO92DR70BAc8QJz+51mzXvdFSb1kcwkvwcNWQ78ZRfnS41hq84A6Ps84PJRij48wy1oonI2tEXx/RHwoWOBcBFev7VNBDLWCo5VFQ3TtBJeHne5STFubET+3Eg1YWcuFhcAIc2zmVrh/W36NY6a4wkl";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

    boolean initFlag = false;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        runPath();
    }

    abstract protected void runPath();

    protected void move(int distance, double power) {

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        //gives power to motors
        robot.leftMotor.setPower(power);
        robot.rightMotor.setPower(power);

        idle();

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //keep going until distance is met
        while( (Math.abs(robot.rightMotor.getCurrentPosition()) < distance * TICKS_PER_INCH) && opModeIsActive() ){

            telemetry.addData("Position: ", robot.rightMotor.getCurrentPosition());
            telemetry.addData("Goal", distance * TICKS_PER_INCH);
            telemetry.update();
            idle();
        }
        //turn the motors off
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }

    protected void move(double distance, double power) {
        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        //gives power to motors
        robot.leftMotor.setPower(power);
        robot.rightMotor.setPower(power);

        idle();

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //keep going until distance is met
        while( (Math.abs(robot.leftMotor.getCurrentPosition()) < distance * TICKS_PER_INCH) && opModeIsActive() ){

            telemetry.addData("position", robot.leftMotor.getCurrentPosition());
            telemetry.update();
            idle();
        }
        //turn the motors off
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }




    protected void pivot(int angle, double power) {

        double d = Math.toRadians(angle) * WHEEL_BASE/2;
        d *= .5;
        d += 0.003 * (double)angle;

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //gives power to motors
        robot.leftMotor.setPower(-Math.signum(angle) * power);
        robot.rightMotor.setPower(Math.signum(angle) * power);

        idle();

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //keep going until distance is met
        while( (Math.abs(robot.leftMotor.getCurrentPosition()) < Math.abs(d) * TICKS_PER_INCH) && opModeIsActive() ){
            telemetry.addData("target",d*TICKS_PER_INCH);
            telemetry.addData("current", robot.leftMotor.getCurrentPosition());
            telemetry.update();
            idle();
        }
        //turn the motors off
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }

    void spin (int duration, double power){
       // robot.fingerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //gives power to motors
       // robot.fingerMotor.setPower(power);
       // robot.fingerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        sleep(duration);

        //turn the motors off
       // robot.fingerMotor.setPower(0);
       // robot.fingerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    void release (){
        //gives power to motors
        //robot.clawLeft.setPosition(0.5);
        //robot.clawRight.setPosition(0.5);

    }

//    public void moveColorSensor (int position){
//        robot.colourStick.setPosition(position);
//    }

                    void moveArm (int power, int time){
                        robot.armMotor.setPower(power);
                        for (int i = 0; i <= time; i++) {
                            sleep(1);
                        }
                        robot.armMotor.setPower(0);}


                    void slideArm ( int power, int time){
                        robot.slideMotor.setPower(power);
                        for (int i = 0; i <= time; i++) {
                            sleep(1);
                        }
                        robot.slideMotor.setPower(0);
                    }
    void closed (int time, int position){
        //gives power to motors
        //robot.clawLeft.setPosition(0);
        //robot.clawRight.setPosition(0);
    }

     public String getOrientationLegacy (){

                 // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
                 // first.
                 if (initFlag == false){
                     initVuforia();
                     initFlag = true;
                     if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
                         initTfod();
                     } else {
                         telemetry.addData("Sorry!", "This device is not compatible with TFOD");
                     }

                 }

//                 /** Wait for the game to begin */
//                 telemetry.addData(">", "Press Play to start tracking");
//                 telemetry.update();
//                 waitForStart();

                 if (opModeIsActive()) {
                     /** Activate Tensor Flow Object Detection. */
                     if (tfod != null) {
                         tfod.activate();
                     }

                     while (opModeIsActive()) {
                         if (tfod != null) {
                             // getUpdatedRecognitions() will return null if no new information is available since
                             // the last time that call was made.
                             List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                             if (updatedRecognitions != null) {
                                 telemetry.addData("# Object Detected", updatedRecognitions.size());
                                 if ((updatedRecognitions.size() == 1) && (updatedRecognitions.size() == 2)) {
                                     return "insufficient";
                                 } else if (updatedRecognitions.size() == 3) {
                                     int goldMineralX = -1;
                                     int silverMineral1X = -1;
                                     int silverMineral2X = -1;
                                     for (Recognition recognition : updatedRecognitions) {
                                         if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                             goldMineralX = (int) recognition.getLeft();
                                         } else if (silverMineral1X == -1) {
                                             silverMineral1X = (int) recognition.getLeft();
                                         } else {
                                             silverMineral2X = (int) recognition.getLeft();
                                         }
                                     }
                                     if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                         if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                             telemetry.addData("Gold Mineral Position", "Left");
                                             return("left");
                                         } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                             telemetry.addData("Gold Mineral Position", "Right");
                                             return("right");
                                         } else {
                                             telemetry.addData("Gold Mineral Position", "Center");
                                             return("center");
                                         }
                                     }
                                 }
                                 telemetry.update();
                             }
                         }
                     }
                 }

                 if (tfod != null) {
                     tfod.shutdown();
                 }

                 return("none");

             }

             /**
              * Initialize the Vuforia localization engine.
              */
             private void initVuforia() {
                 /*
                  * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
                  */
                 VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

                 parameters.vuforiaLicenseKey = VUFORIA_KEY;
                 parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

                 //  Instantiate the Vuforia engine
                 vuforia = ClassFactory.getInstance().createVuforia(parameters);

                 // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
             }

             /**
              * Initialize the Tensor Flow Object Detection engine.
              */
             private void initTfod() {
                 int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                         "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
                 TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
                 tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
                 tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
             }

    public int getOrientation (){

        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.
        if (initFlag == false){
            initVuforia();
            initFlag = true;
            if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
                initTfod();
            } else {
                telemetry.addData("Sorry!", "This device is not compatible with TFOD");
            }

        }

//                 /** Wait for the game to begin */
//                 telemetry.addData(">", "Press Play to start tracking");
//                 telemetry.update();
//                 waitForStart();

        if (opModeIsActive()) {
            /** Activate Tensor Flow Object Detection. */
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        if ((updatedRecognitions.size() == 0) && (updatedRecognitions.size() == 1)) {
                            return(0);
                        }
                        else if ((updatedRecognitions.size() == 2) && opModeIsActive()){
                            int goldMineralX = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                    return(1); //left
                                } else if (goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                    return(2); //center
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                    return(3); //right
                                }
                            }
                        }
                        else if ((updatedRecognitions.size() == 3) && opModeIsActive()) {
                            int goldMineralX = -1;
                            int silverMineral1X = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else if (silverMineral1X == -1) {
                                    silverMineral1X = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                    return(1); //left
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                    return(3); //right
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                    return(2); //center
                                }
                            }
                        }
                        telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
            //tfod.deactivate();
        }

        return(0);

    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia2() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }

    /**
     * Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod2() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }
         }





