package org.firstinspires.ftc.teamcode.Autonomous;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.tuningVal.MecanumDrive;

@Config
@Autonomous(name = "PSUHBOTRS", group = "Autonomous")
public class PUSHBOT_RS extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(11.8, 61.7, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        Vector2d basket = new Vector2d(-55,-55);
        Vector2d spawn2 = new Vector2d(-55,-15);
        Vector2d spawn3 = new Vector2d(-65,-15);
        TrajectoryActionBuilder pgm = drive.actionBuilder(initialPose)
                .lineToY(-10)
                .waitSeconds(0.0001)
                .turn(Math.toRadians(135))
                .waitSeconds(0.0001)
                .splineTo(basket,Math.toRadians(-135))
                .lineToX(-30)
                .waitSeconds(0.0001)
                .splineTo(spawn2,Math.toRadians(-90))
                .waitSeconds(0.0001)
                .splineTo(basket,Math.toRadians(-135))
                .lineToX(-40)
                .waitSeconds(0.0001)
                .splineTo(spawn3,Math.toRadians(-90))
                .waitSeconds(0.0001)
                .lineToX(-40)
                .waitSeconds(0.0001)
                .splineTo(basket,Math.toRadians(-135));


        Action trajectoryActionCloseOut = pgm.fresh()
                .splineTo(new Vector2d(-15,-15),Math.toRadians(0))
                .build();


        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        trajectoryActionChosen = pgm.build();

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        trajectoryActionCloseOut
                )
        );
    }
}