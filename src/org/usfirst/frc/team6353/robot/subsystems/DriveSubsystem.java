package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.DriveWithJoystickCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP driveFrontLeft;
	VictorSP driveFrontRight;
	VictorSP driveRearLeft;
	VictorSP driveRearRight;
	RobotDrive robotDrive;
	
	public DriveSubsystem(){
		System.out.println("Creating Drive system");
		driveFrontLeft = new VictorSP(RobotMap.DriverFrontLeftPort);
		driveFrontRight = new VictorSP(RobotMap.DriverFrontRightPort);
		driveRearLeft = new VictorSP(RobotMap.DriverRearLeftPort);
		driveRearRight = new VictorSP(RobotMap.DriverRearRightPort);
		
		robotDrive = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
		
		System.out.println("Dr iveSubsystem Initializing");
	}
    public void initDefaultCommand() {
    	System.out.println("SetDefaultCommand");
    	setDefaultCommand(new DriveWithJoystickCommand());
    	System.out.println("Set complete");
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    public void stop(){
    	robotDrive.tankDrive(0, 0);
    }
    
    public void tankDrive(Joystick joy) {
    	robotDrive.tankDrive(0.1*joy.getRawAxis(RobotMap.DriverVerticalLeftAxisPort),
    			0.1*joy.getRawAxis(RobotMap.DriverVerticalRightAxisPort));
    	System.out.println("The two axis values are:");
    	System.out.println(0.1*joy.getRawAxis(RobotMap.DriverVerticalLeftAxisPort));
    	System.out.println(0.1*joy.getRawAxis(RobotMap.DriverVerticalRightAxisPort));
    }
    
    public void tankDrive(double leftValue, double rightValue) {
		robotDrive.tankDrive(leftValue, rightValue);
	}

	public void tankDrive(double leftValue, double rightValue, boolean isSquareInput) {
		robotDrive.tankDrive(leftValue, rightValue, isSquareInput);
	}
}

