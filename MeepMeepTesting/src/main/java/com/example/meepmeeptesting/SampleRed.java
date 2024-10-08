package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class SampleRed  {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(100, 100, Math.toRadians(270), Math.toRadians(270), 15)
                .build();

        Vector2d yellow = new Vector2d(-55,-42);
        Vector2d end = new Vector2d(-25,-10);
        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-10, -61, Math.toRadians(-90)))
                .lineToY(-36)
                .waitSeconds(0.0001)
                .splineTo(yellow,Math.toRadians(100))
                .lineToYSplineHeading(-55,Math.toRadians(45))
                .lineToYSplineHeading(-42,Math.toRadians(70))
                .lineToYSplineHeading(-55,Math.toRadians(45))
                .lineToYSplineHeading(-42,Math.toRadians(130))
                .lineToYSplineHeading(-55,Math.toRadians(45))//idk
                        .waitSeconds(0.01)
                .splineTo(end,Math.toRadians(0))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}