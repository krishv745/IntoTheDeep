package org.firstinspires.ftc.teamcode.Autonomous;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Config()
@Autonomous(name = "motorLeft", group = "Pushbot")



public class motorPowerPushbotSample extends LinearOpMode {
    DcMotor backLeftDrive;
    DcMotor backRightDrive;
    DcMotor frontLeftDrive;
    DcMotor frontRightDrive;


    @Override
    public void runOpMode() {
        backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
        backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
        frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");


        // Put initialization blocks here
        waitForStart();
        backRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
//        frontRightDrive.setPower(0.3);
//        backLeftDrive.setPower(0.3);
//        backRightDrive.setPower(-0.3);
//        frontLeftDrive.setPower(-0.3);
//        sleep(0.2700);
//        frontRightDrive.setPower(0);
//        backLeftDrive.setPower(0);
//        backRightDrive.setPower(0);
//        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(-0.3);
        frontLeftDrive.setPower(-0.3);
        backRightDrive.setPower(0.3);
        sleep(400);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        backRightDrive.setPower(0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(-0.3);
        frontLeftDrive.setPower(-0.3);
        backRightDrive.setPower(0.3);
        sleep(1700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        backRightDrive.setPower(0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(-0.3);
        backLeftDrive.setPower(-0.3);
        frontLeftDrive.setPower(-0.3);
        backRightDrive.setPower(-0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(-0.3);
        backLeftDrive.setPower(-0.3);
        backRightDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        sleep(800);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        backRightDrive.setPower(0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(-0.3);
        backLeftDrive.setPower(-0.3);
        frontLeftDrive.setPower(-0.3);
        backRightDrive.setPower(-0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(-0.3);
        backLeftDrive.setPower(-0.3);
        backRightDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        sleep(800);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0.3);
        backLeftDrive.setPower(0.3);
        frontLeftDrive.setPower(0.3);
        backRightDrive.setPower(0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(-0.3);
        backLeftDrive.setPower(-0.3);
        frontLeftDrive.setPower(-0.3);
        backRightDrive.setPower(-0.3);
        sleep(2700);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        frontLeftDrive.setPower(0);
    }

}

