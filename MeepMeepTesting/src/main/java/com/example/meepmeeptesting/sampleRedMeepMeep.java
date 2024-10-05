    package com.example.meepmeeptesting;

    import com.acmerobotics.roadrunner.Pose2d;
    import com.acmerobotics.roadrunner.Vector2d;
    import com.noahbres.meepmeep.MeepMeep;
    import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
    import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

    import java.awt.Image;
    import java.io.File;
    import java.io.IOException;

    import javax.imageio.ImageIO;

    public class sampleRedMeepMeep {
        public static void main(String[] args) {
            MeepMeep meepMeep = new MeepMeep(700);

            RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .build();

            myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-17.9, -61, 0))
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
                    .strafeTo(new Vector2d(-58,-60))
                    .build());

            meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                    .setDarkMode(true)
                    .setBackgroundAlpha(0.95f)
                    .addEntity(myBot)
                    .start();

















        }
    }