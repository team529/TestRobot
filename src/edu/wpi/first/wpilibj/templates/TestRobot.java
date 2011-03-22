/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class TestRobot extends IterativeRobot {
    private Joystick jsLeft = new Joystick(1);
    private Joystick jsRight = new Joystick (2);

    private Jaguar jagleft1 = new Jaguar(1);
    private Jaguar jagleft2 = new Jaguar(2);
    private Jaguar jagright1 = new Jaguar (3);
    private Jaguar jagright2 = new Jaguar (4);

    private RobotDrive robot = new RobotDrive (jagleft1, jagleft2, jagright1, jagright2);


    private Jaguar jagarm1 = new Jaguar (9);
    private Jaguar jagarm2 = new Jaguar (10);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        /*
         * Change direction of the motors
         * false - motor is not reversed
         * true - motor is reversed
         *
         * CHANGE IN PAIRS. Change both LEFT or both RIGHT
         */
        robot.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        robot.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);

        robot.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robot.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        robot.arcadeDrive(jsLeft, true);
        
        jagarm1.set(jsRight.getY() * Math.abs(jsRight.getY()) * 0.6);
        jagarm2.set(jsRight.getY() * Math.abs(jsRight.getY()) * 0.6);
    }
    
}
