package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class SpecimenRed {
    public static void main(String[] args) {
        Vector2d pos1 = new Vector2d(58,-40);
        Vector2d pos2 = new Vector2d(55,-40);
        Vector2d pos3 = new Vector2d(50,-40);
        Vector2d home = new Vector2d(60,-48);
        Vector2d target = new Vector2d(10,-36);
        Vector2d end = new Vector2d(60,-60);



        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(80, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(10, -60, Math.toRadians(90)))
                .lineToY(-33)
                .waitSeconds(0.5)
                .lineToY(-40)
                .strafeTo(pos1)
                .turn(Math.toRadians(-30))
                .waitSeconds(0.5)
                .splineTo(home,Math.toRadians(-90))
                .waitSeconds(0.5)
                .splineTo(pos2,Math.toRadians(90))
                .waitSeconds(0.5)
                .splineTo(home,Math.toRadians(-90))
                .waitSeconds(0.5)
                .splineTo(target,Math.toRadians(90))
                .waitSeconds(0.5)
                .strafeTo(pos3)
                .waitSeconds(0.5)
                .splineTo(home,Math.toRadians(-90))
                .waitSeconds(0.5)
                .splineTo(target,Math.toRadians(90))
                .waitSeconds(0.5)
                .lineToY(-42)
                .splineTo(home,Math.toRadians(90))
                .waitSeconds(0.5)
                .splineTo(target,Math.toRadians(90))
                .waitSeconds(0.5)
                .strafeTo(end)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}