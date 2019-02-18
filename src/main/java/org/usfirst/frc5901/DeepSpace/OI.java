// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5901.DeepSpace;

import org.usfirst.frc5901.DeepSpace.commands.*;
import org.usfirst.frc5901.DeepSpace.subsystems.Forearm;
import org.usfirst.frc5901.DeepSpace.subsystems.Rollers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick controller1;
    public Joystick controller2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        
        controller1 = new Joystick(0);
        
        JoystickButton buttonA_1 = new JoystickButton(controller1, 1);
        JoystickButton buttonB_1 = new JoystickButton(controller1, 2);
        JoystickButton buttonX_1 = new JoystickButton(controller1, 3);
        JoystickButton buttonY_1 = new JoystickButton(controller1, 4);
        buttonA_1.whileHeld(new ElevatorDown());
        buttonB_1.whileHeld(new CompressorON());
        buttonX_1.whileHeld(new ElevatorDown());
        buttonY_1.whileHeld(new ElevatorUp());

        controller2 = new Joystick(1);

        JoystickButton buttonA_2 = new JoystickButton(controller2, 1);
        JoystickButton buttonB_2 = new JoystickButton(controller2, 2);
        JoystickButton buttonX_2 = new JoystickButton(controller2, 3);
        JoystickButton buttonY_2 = new JoystickButton(controller2, 4);
        buttonB_2.whileHeld(new BallEnter());
        buttonY_2.whileHeld(new ArmDown());
        buttonA_2.whileHeld(new ArmUp());
        buttonX_2.whileHeld(new BallEscape());
        




        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DefaultDrive", new DefaultDrive());

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getController1() {
        return controller1;
    }

    public Joystick getController2() {
        return controller2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

