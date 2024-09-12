package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.robotFunc.BotFunc;

@TeleOp
public class FOTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // objects
        BotFunc bot = new BotFunc();

        // variabes

        //motors and servos
        DcMotor fl = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor bl = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor fr = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor br = hardwareMap.dcMotor.get("backRightMotor");


        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);


        IMU imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));

        imu.initialize(parameters);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;


            if (gamepad1.options) {
                imu.resetYaw();
            }

            if (gamepad1.left_bumper ){
                bot.wrist();
            }

            if (gamepad1.right_bumper){
                bot.claw();
            }


            //drive
            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);


            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;


            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double flp = (rotY + rotX + rx) / denominator;
            double blp = (rotY - rotX + rx) / denominator;
            double frp = (rotY - rotX - rx) / denominator;
            double brp = (rotY + rotX - rx) / denominator;

            fl.setPower(flp);
            bl.setPower(blp);
            fr.setPower(frp);
            br.setPower(brp);

        }
    }
}