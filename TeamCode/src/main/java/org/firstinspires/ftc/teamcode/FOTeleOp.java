package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class FOTeleOp extends OpMode {

    IMU imu;

    //Drivetrain Motors
    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;
    //Other Motors
    DcMotorEx motorOuttakeSlidesL;
    DcMotorEx motorOuttakeSlidesR;
//    DcMotorEx rigSlidesMotor;
    DcMotorEx motorTurret;

    //Outtake Servos
    Servo servoOutClaw;
    Servo servoOutRotate;
    //Intake Servos
    CRServo servoIntakeL;
    CRServo servoIntakeR;
    CRServo servoIntakeF;
    Servo servoIntakeRotate;
    //Intake Slides Servos
    Servo servoIntakeSlidesR;
    Servo servoIntakeSlidesL;

    //Variables
    double y = 0;
    double x = 0;
    double rx = 0;

    public enum IntakeState {
        intakeIn,
        intakeOut,
        intakeRotateDown,
        intakeRun,
        intakeRotateUp,
        intakeRetract
    };
//    public enum SampleDrop {
//        IntakeSlidesRetract,
//        IntakeRotate,
//        OuttakeHold,
//        OuttakeRotate
//    };

    //This is the timer for the arm
    ElapsedTime timerIntakeSlides = new ElapsedTime();
    IntakeState intakeState = IntakeState.intakeIn;

    @Override
    public void init() {
        motorFrontLeft = hardwareMap.dcMotor.get("frontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("frontRight");
        motorBackLeft = hardwareMap.dcMotor.get("backLeft");
        motorBackRight = hardwareMap.dcMotor.get("backRight");
        motorOuttakeSlidesL = (DcMotorEx) hardwareMap.dcMotor.get("outtakeLeft");
        motorOuttakeSlidesR = (DcMotorEx) hardwareMap.dcMotor.get("outtakeRight");
//        rigSlidesMotor = (DcMotorEx) hardwareMap.dcMotor.get("intake");
        motorTurret = (DcMotorEx) hardwareMap.dcMotor.get("turret");

        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorOuttakeSlidesL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorOuttakeSlidesR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        rigSlidesMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorTurret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorOuttakeSlidesL.setMode(DcMotor.RunMode.RUN_TO_POSITION); // vertical - 5000 ticks
        motorOuttakeSlidesR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        rigSlidesMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION); // horizontal - 4000 ticks
        motorTurret.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        servoOutClaw = hardwareMap.servo.get("outClaw");
        servoOutRotate = hardwareMap.servo.get("outRotate");
        servoIntakeF = (CRServo) hardwareMap.servo.get("inF");
        servoIntakeL = (CRServo) hardwareMap.servo.get("inL");
        servoIntakeR = (CRServo) hardwareMap.servo.get("inR");
        servoIntakeRotate = hardwareMap.servo.get("inRotate");
        servoIntakeSlidesR = hardwareMap.servo.get("inSlideR");
        servoIntakeSlidesL = hardwareMap.servo.get("inSlideL");

        imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        timerIntakeSlides.reset();
    }

    @Override
    public void start() {
        servoOutClaw.setPosition(0.3); //0.5
        servoOutRotate.setPosition(0.15); //0.85
        servoIntakeL.setPower(0); //1
        servoIntakeR.setPower(0); //1
        servoIntakeF.setPower(0); //1
        servoIntakeRotate.setPosition(0.3); //0.6
        servoIntakeSlidesL.setPosition(0.3); //0.7
        servoIntakeSlidesR.setPosition(0.3); //0.7
    }

    @Override
    public void loop() {
//        public enum IntakeState {
//            intakeIn,
//            intakeOut,
//            intakeRotateDown,
//            intakeRun,
//            intakeRotateUp,
//            intakeRetract
//        };

        switch (intakeState) {
            case intakeOut:
                if (servoIntakeSlidesL.getPosition() <= 0.31 && servoIntakeSlidesR.getPosition() <= 0.31) {
                    if (gamepad2.left_stick_y > 0)
                }

                    servoIntakeSlidesL.setPosition(0.7);
                    servoIntakeSlidesR.setPosition(0.7);

                }
                timerIntakeSlides.reset();
            case intakeRotateDown:

            case intakeSlideOut:
                timer.reset();
                rigSlidesMotor.setTargetPosition(IN_SLIDES_OUT);
                while (timer.milliseconds() < IN_SLIDES_TIMER) {

                }
                intakeState = intakeState.intakeWheelRun;
            case intakeWheelRun:
                double distance = ((DistanceSensor) color).getDistance(DistanceUnit.CM);
                while (distance > 0.1) {
                    servoIntakeF.setPower(ROLL_ON);
                    servoIntakeL.setPower(ROLL_ON);
                    servoIntakeR.setPower(ROLL_ON);
                }

                servoIntakeF.setPower(ROLL_OFF);
                servoIntakeL.setPower(ROLL_OFF);
                servoIntakeR.setPower(ROLL_OFF);

                intakeState = intakeState.intakeSlideIn;
            case intakeSlideIn:
                timer.reset();
                rigSlidesMotor.setTargetPosition(IN_SLIDES_IN);
                while (timer.milliseconds() < IN_SLIDES_TIMER) {

                }
                intakeState = intakeState.intakeRest;
        }



        if (gamepad1.right_trigger > 0) {
            y = -gamepad1.left_stick_y - gamepad1.right_stick_y; // Remember, this is reversed!
            x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            rx = -gamepad1.right_stick_x;
        } else if (gamepad1.left_trigger > 0) {
            y = -0.25 * (gamepad1.left_stick_y + gamepad1.right_stick_y); // Remember, this is reversed!
            x = 0.25 * gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            rx = -0.35 * gamepad1.right_stick_x;
        } else {
            y = -0.5 * (gamepad1.left_stick_y + gamepad1.right_stick_y); // Remember, this is reversed!
            x = 0.5 * gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            rx = -0.65 * gamepad1.right_stick_x;
        }

        if (gamepad1.back) {
            imu.resetYaw();
        }

        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS) + Math.toRadians(90);

        // Rotate the movement direction counter to the bot's rotation
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;

        motorFrontLeft.setPower(frontLeftPower);
        motorFrontRight.setPower(frontRightPower);
        motorBackLeft.setPower(backLeftPower);
        motorBackRight.setPower(backRightPower);
    }
}