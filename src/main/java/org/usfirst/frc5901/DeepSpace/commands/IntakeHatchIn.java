/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.commands;

import org.usfirst.frc5901.DeepSpace.Robot;
import org.usfirst.frc5901.DeepSpace.subsystems.HatchIntake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeHatchIn extends Command {
  public IntakeHatchIn() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("HatchIntakeIn");
    Robot.hatchIntake.PistonIn();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    System.out.println("HatchOut");
   ((HatchIntake) Robot.hatchOut).PistonOut();

  }

public static void setClosedLoopControl() {
}

}

