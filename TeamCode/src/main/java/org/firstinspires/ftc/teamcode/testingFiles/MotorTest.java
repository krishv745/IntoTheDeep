package org.firstinspires.ftc.teamcode.testingFiles;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

    public class MotorTest extends LinearOpMode {
        DcMotorEx motor;

        @Override
        public void runOpMode() throws InterruptedException {
            motor = hardwareMap.get(DcMotorEx.class, "motor");
            double val = 0.1;
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            waitForStart();
            while (opModeIsActive()) {

            }
            while (opModeIsActive()) {
                if (gamepad1.dpad_up) {
                    val += 0.1;
                } else if (gamepad1.dpad_right) {
                    val += 0.05;
                } else if (gamepad1.dpad_down) {
                    val -= 0.1;
                } else if (gamepad1.dpad_left) {
                    val -= 0.05;
                }
                if (gamepad1.a) {
                    motor.setPower(0.1);
                } else if (gamepad1.b) {
                    motor.setPower(0.0);
                }
            }
        }
    }


