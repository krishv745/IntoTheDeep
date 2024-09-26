package org.firstinspires.ftc.teamcode.Autonomous;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.tuningVal.MecanumDrive;

@Config
@Autonomous(name = "RED_SAMPLE_AUTO", group = "Autonomous")
public class RED_SAMPLE_TEST extends LinearOpMode {


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-17.9, -61, 0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        
        int visionOutputPosition =1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .lineToX(-48)
                .turn(Math.toRadians(90))
                .lineToY(-28)
                .waitSeconds(1)
                .lineToY(-48)
                .lineToYSplineHeading(-52,Math.toRadians(235))
                .strafeTo(new Vector2d(-58,-60))
                .waitSeconds(1)
                .turn(Math.toRadians(220))
                .strafeTo(new Vector2d(-58,-28))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-58,-60))
                .turn(Math.toRadians(120))
                .waitSeconds(1)
                .turn(Math.toRadians(-90))
                .strafeTo(new Vector2d(-58,-28))
                .turn(Math.toRadians(90))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-58,-60))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-20,0))
                .turn(Math.toRadians(-90))
                .waitSeconds(1)
                .strafeTo(new Vector2d(-58,-60));


        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }
        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;
        
        Action trajRunner = tab1.build();

        Actions.runBlocking(
                new SequentialAction(
                        trajRunner
                )
        );
    }
}
