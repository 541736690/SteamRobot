package org.usfirst.frc.team6353.robot.subsystems;

import org.usfirst.frc.team6353.robot.RobotMap;
import org.usfirst.frc.team6353.robot.commands.BallCollectDefaultCommand;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallCollectSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private int status = 0;
	private VictorSP ballCollectWheel;
	
	public BallCollectSubsystem(){
		ballCollectWheel = new VictorSP(RobotMap.BallCollectMotorPort);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new BallCollectDefaultCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void changePositiveStatus() {
    	status = ( status == 1 ? 0 : 1 );
    }
    
    public void changeNegativeStatus() {
    	status = ( status == -1 ? 0 : -1 );
    }
    
    public void run(){
    	ballCollectWheel.setSpeed(-0.8 * status);
    }
    
    public void collect() {
//    	System.out.println("Collecting Balls");
    	ballCollectWheel.setSpeed(-0.8);
    }
    
    public void stop(){
    	ballCollectWheel.setSpeed(0);
    }
    
   
    
}

