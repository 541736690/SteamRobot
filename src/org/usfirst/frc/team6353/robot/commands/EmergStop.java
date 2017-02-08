package org.usfirst.frc.team6353.robot.commands;

import org.usfirst.frc.team6353.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EmergStop extends Command {

    public EmergStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	setTimeout(.1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = Robot.driveSubsystem.getLeftSpeed() > 0.0 ? -1 : 1;
    	double rightSpeed = Robot.driveSubsystem.getRightSpeed() > 0.0 ? -1 : 1;
    	Robot.driveSubsystem.tankDrive(leftSpeed,rightSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
