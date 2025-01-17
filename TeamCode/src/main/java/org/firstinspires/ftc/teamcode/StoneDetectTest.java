package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.framework.drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.framework.drivetrain.Mecanum;
import org.firstinspires.ftc.teamcode.framework.subsystems.vision.TFStoneDetector;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TFStone: Working proof of concept", group = "Concept")
public class StoneDetectTest extends LinearOpMode {

    TFStoneDetector stoneDetector = new TFStoneDetector();

    public void runOpMode() {
        stoneDetector.initVuforia(this, "Webcam 1");
        stoneDetector.initTfod(0.55); // Lower confidence can distinguish between individual stones better
        stoneDetector.activateTF();
        while (!opModeIsActive() && !isStopRequested()) {
            stoneDetector.detectStoneSilent();
        }
        waitForStart();

        while (opModeIsActive()) {
            stoneDetector.detectStone();
        }
        stoneDetector.shutdownTF();
    }
}