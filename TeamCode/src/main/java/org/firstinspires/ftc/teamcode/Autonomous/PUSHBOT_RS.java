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
@Autonomous(name = "DO_NOT_RUN", group = "Autonomous")
public class PUSHBOT_RS extends LinearOpMode {
//    public class Lift {
//        private DcMotorEx lift;
//
//        public Lift(HardwareMap hardwareMap) {
//            lift = hardwareMap.get(DcMotorEx.class, "liftMotor");
//            lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            lift.setDirection(DcMotorSimple.Direction.FORWARD);
//        }
//
//        public class LiftUp implements Action {
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                if (!initialized) {
//                    lift.setPower(0.8);
//                    initialized = true;
//                }
//
//                double pos = lift.getCurrentPosition();
//                packet.put("liftPos", pos);
//                if (pos < 3000.0) {
//                    return true;
//                } else {
//                    lift.setPower(0);
//                    return false;
//                }
//            }
//        }
//        public Action liftUp() {
//            return new LiftUp();
//        }
//
//        public class LiftDown implements Action {
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                if (!initialized) {
//                    lift.setPower(-0.8);
//                    initialized = true;
//                }
//
//                double pos = lift.getCurrentPosition();
//                packet.put("liftPos", pos);
//                if (pos > 100.0) {
//                    return true;
//                } else {
//                    lift.setPower(0);
//                    return false;
//                }
//            }
//        }
//        public Action liftDown(){
//            return new LiftDown();
//        }
//    }
//
//    public class Claw {
//        private Servo claw;
//
//        public Claw(HardwareMap hardwareMap) {
//            claw = hardwareMap.get(Servo.class, "claw");
//        }
//
//        public class CloseClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.55);
//                return false;
//            }
//        }
//        public Action closeClaw() {
//            return new CloseClaw();
//        }
//
//        public class OpenClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(1.0);
//                return false;
//            }
//        }
//        public Action openClaw() {
//            return new OpenClaw();
//        }
//    }

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(11.8, 61.7, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
//        Claw claw = new Claw(hardwareMap);
//        Lift lift = new Lift(hardwareMap);

        // vision here that outputs position
//        int visionOutputPosition = 1;
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

//        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
//                .lineToY(37)
//                .setTangent(Math.toRadians(0))
//                .lineToX(18)
//                .waitSeconds(3)
//                .setTangent(Math.toRadians(0))
//                .lineToXSplineHeading(46, Math.toRadians(180))
//                .waitSeconds(3);
//        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
//                .lineToYSplineHeading(33, Math.toRadians(180))
//                .waitSeconds(2)
//                .strafeTo(new Vector2d(46, 30))
//                .waitSeconds(3);
        Action trajectoryActionCloseOut = pgm.fresh()
                .splineTo(new Vector2d(-15,-15),Math.toRadians(0))
                .build();

        // actions that need to happen on init; for instance, a claw tightening.
//        Actions.runBlocking(claw.closeClaw());


//        while (!isStopRequested() && !opModeIsActive()) {
//            int position = visionOutputPosition;
//            telemetry.addData("Position during Init", position);
//            telemetry.update();
//        }

//        int startPosition = visionOutputPosition;
//        telemetry.addData("Starting Position", startPosition);
//        telemetry.update();
//        waitForStart();



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