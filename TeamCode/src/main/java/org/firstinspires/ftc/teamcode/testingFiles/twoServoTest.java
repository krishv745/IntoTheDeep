package org.firstinspires.ftc.teamcode.testingFiles;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(group = "testing")
    public class twoServoTest extends LinearOpMode {
        @Override
        public void runOpMode() throws InterruptedException {
            ElapsedTime timer = new ElapsedTime();
            Servo testing = hardwareMap.servo.get("servo");
            double val = 0.1;
            waitForStart();
            if(isStopRequested()) return;
            while (opModeIsActive()) {
                if (timer.milliseconds() > 250) {
                    if (gamepad1.dpad_up) {
                        val += 0.1;
                    } else if (gamepad1.dpad_right) {
                        val += 0.05;
                    } else if (gamepad1.dpad_down) {
                        val -= 0.1;
                    } else if (gamepad1.dpad_left) {
                        val -= 0.05;
                    }
                    timer.reset();
                }
                if (val > 0.06 && val < 0.94) {
                    testing.setPosition(val);

                }
                telemetry.addData("pos = ", val);
                telemetry.update();
            }
        }
    }
