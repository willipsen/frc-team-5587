package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class HI 
{
	private Joystick stick;
	private Joystick stickSecond;
	
	private JoystickButton slowButton;

	public HI() 
	{
		stick = new Joystick(RobotPorts.joystickMain);
		stickSecond = new Joystick(RobotPorts.joystickSecond);
		
		slowButton = new JoystickButton( stick, 5 );
	}
	
	public Joystick getstick() //this is currently used for driving 
	{
		return stick;
	}
	
	public Joystick getstick2() // currently used for lift
	{
		return stickSecond;
	}
	
	public boolean isSlow()
	{
		return slowButton.get();
	}
}