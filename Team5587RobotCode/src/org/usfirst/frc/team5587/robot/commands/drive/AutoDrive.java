package org.usfirst.frc.team5587.robot.commands.drive;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.subsystems.Feet;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Simple Command to drive robot forwards based on encoder input
 */
public class AutoDrive extends Command
{
	private double curve;
	private double distance;
	private double leftD;
	private double rightD;
	
    public AutoDrive( double distance, double curve )
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.curve = curve;
    	this.distance = distance;
    	
    	requires( Robot.feet);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	double [] distances = Robot.feet.scaleDistance( distance, curve );
    	
    	leftD = distances[ 0 ];
    	rightD = distances[ 1 ];
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	double leftCount = Robot.feet.getDistance( Feet.left );
    	double rightCount = Robot.feet.getDistance( Feet.right );
    	
    	if( leftCount >= leftD || rightCount >= rightD)
    	{
    		Robot.feet.stopFeet();
    	}
    	else
    	{
    		Robot.feet.drive( 1, curve );
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return true;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	
    }
}