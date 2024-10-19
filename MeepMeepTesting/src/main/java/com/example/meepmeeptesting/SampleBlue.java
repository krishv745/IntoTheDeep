package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class SampleBlue{
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(100, 100, Math.toRadians(270), Math.toRadians(270), 15)
                .build();

        Vector2d yellow = new Vector2d(55,42);
        Vector2d end = new Vector2d(25,10);
        Vector2d basket = new Vector2d(55,55);
        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, 61, Math.toRadians(90)))
                .lineToY(36)
                .waitSeconds(0.0001)
                .splineTo(yellow,Math.toRadians(-80))
                .lineToYSplineHeading(55,Math.toRadians(-135))
                .lineToYSplineHeading(42,Math.toRadians(-115))
                .lineToYSplineHeading(55,Math.toRadians(-135))
                .lineToYSplineHeading(42,Math.toRadians(-50))
                .lineToYSplineHeading(55,Math.toRadians(-135))//idk
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))
                .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(180))
                .waitSeconds(0.01)
                .lineToX(40)
                .splineTo(basket,Math.toRadians(45))

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}