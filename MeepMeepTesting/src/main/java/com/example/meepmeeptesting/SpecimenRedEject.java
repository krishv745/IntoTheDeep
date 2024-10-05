package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class SpecimenRedEject {
    public static void main(String[] args) {
        Vector2d p1 = new Vector2d(40,-42);
        Vector2d p2 = new Vector2d(50,-42);
        Vector2d p3 = new Vector2d(58,-42);
        Vector2d target = new Vector2d(10,-35);
        Vector2d end = new Vector2d(60,-60);
        Vector2d recieve = new Vector2d(58,-58);



        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(80, 60, Math.toRadians(360), Math.toRadians(360), 15)
                .build();


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, -60, Math.toRadians(90)))
                .lineToY(-35)
                .waitSeconds(0.5)
                .lineToY(-40)
                .waitSeconds(0.01)
                .splineTo(p1,Math.toRadians(60))
                .waitSeconds(0.5)
                .turn(Math.toRadians(-120))
                .waitSeconds(0.5)
                .splineTo(p2,Math.toRadians(60))
                .waitSeconds(0.5)
                .turn(Math.toRadians(-120))
                .waitSeconds(0.5)
                .splineTo(p3,Math.toRadians(60))
                .waitSeconds(0.5)
                .turn(Math.toRadians(-150))
                        .waitSeconds(0.5)
                        .lineToY(-60)
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(target,Math.toRadians(90))
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(recieve,Math.toRadians(-90))
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(target,Math.toRadians(90))
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(recieve,Math.toRadians(-90))
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(target,Math.toRadians(90))
                        .waitSeconds(0.5)
                        .lineToY(-50)
                        .waitSeconds(0.01)
                        .splineTo(recieve,Math.toRadians(-90))
                        .lineToY(-65)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}