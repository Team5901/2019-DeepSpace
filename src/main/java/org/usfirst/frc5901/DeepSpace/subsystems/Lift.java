/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private Compressor CompressorOne = new Compressor(0);
  public Solenoid RearOne = new Solenoid(3);
  public Solenoid MiddlesoulSolenoid  = new Solenoid(4);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public void RaiseRear(){
  RearOne.set(true);
}
public void DropRear() {
  RearOne.set(false);

}

public void RaiseMiddleSolenoid(){
  MiddlesoulSolenoid.set(true);
}
public void DropMiddleSolenoid() {
  MiddlesoulSolenoid.set(false);

}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
