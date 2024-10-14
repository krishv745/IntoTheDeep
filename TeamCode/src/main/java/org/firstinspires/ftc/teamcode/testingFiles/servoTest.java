package org.firstinspires.ftc.teamcode.testingFiles;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "testing")
public class servoTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Servo testing = hardwareMap.servo.get("servo");
        double val = 0.1;
        waitForStart();
        if(isStopRequested()) return;
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
            if (val > 0.06 && val < 0.94) {
                testing.setPosition(val);
            }
            telemetry.addData("pos = ", val);
            telemetry.update();
        }
    }
}
