/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchIntakeMine extends Subsystem {

  //All Selenoids are instantiated in Forearm and Hand
  private Compressor compressor = new Compressor(0);
  private Forearm forearm = new Forearm();
  private Hand hand = new Hand();

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void grasp() {
    this.forearm.extend();
    this.hand.open();
  }

  public void release() {
    this.hand.close();
    this.forearm.compress();
  }
}
