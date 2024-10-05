package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.util.Vector;

public class SpecimenRedTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(30, -61, 0))

                .strafeTo(new Vector2d(48, -40))
                .turn(Math.toRadians(90))
                .turn(Math.toRadians(-180))
                .lineToY(-59)
                .strafeTo(new Vector2d(58, -40))
                .turn(Math.toRadians(-180))
                .turn(Math.toRadians(-180))
                .lineToY(-59)
                .turn(Math.toRadians(-180))
                .turn(Math.toRadians(90))
                .lineToX(48)
                .turn(Math.toRadians(-90))
                .strafeTo(new Vector2d(8, -31))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }

}