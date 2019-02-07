/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import org.usfirst.frc5901.DeepSpace.subsystems.SolenoidState;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Hand extends Subsystem implements SolenoidState {

  private Solenoid selenoid = new Solenoid(1);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  //For grabbing hatch
  public void open() {
    this.selenoid.set(ON);
  }

  //For releasing hatch
  public void close() {
    this.selenoid.set(OFF);
  }

  
}
