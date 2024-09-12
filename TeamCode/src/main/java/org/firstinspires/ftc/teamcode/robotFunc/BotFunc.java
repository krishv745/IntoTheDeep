package org.firstinspires.ftc.teamcode.robotFunc;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotDrive;

public class BotFunc extends RobotDrive {
    final double openpos = 0.0;
    final double closepos = 0.0;
    final double wristposdown = 0.0;
    final double wristposup = 0.0;

    public Servo claw;
    public Servo wrist;
        public void init(HardwareMap hardwareMap) {

        claw = hardwareMap.servo.get("claw"); //Closes claw
        wrist = hardwareMap.servo.get("wrist"); //Changes pitch of claw

        super.init(hardwareMap); //runs the robot drive part
    }

    public void claw(){

            if (claw.getPosition() == closepos){
                claw.setPosition(openpos);
            }
            else{
                claw.setPosition(closepos);
            }
    }

    public void wrist(){
            if (wrist.getPosition() == wristposdown){
                wrist.setPosition(wristposup);
            }
            else {
                wrist.setPosition(wristposdown);
            }
    }

}
