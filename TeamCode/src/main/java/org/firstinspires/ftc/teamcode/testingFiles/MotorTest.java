package org.firstinspires.ftc.teamcode.testingFiles;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

    public class MotorTest extends LinearOpMode {
        DcMotorEx motor;
        @Override
        public void runOpMode() throws InterruptedException {
            motor = hardwareMap.get(DcMotorEx.class, "arm");

            // use braking to slow the motor down faster
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            waitForStart();
            while (opModeIsActive()) {
                motor.setPower(0.5);
            }
        }
    }


