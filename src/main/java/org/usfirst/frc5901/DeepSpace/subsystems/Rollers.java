/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Rollers extends Subsystem implements MotorSpeeds {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_VictorSPX rolliepollie;

  //Constructor
  public Rollers() {
    //Im not sure if 3 is gonna be the port we're using
    rolliepollie = new WPI_VictorSPX(8);
  }

  //Two methods for rolling in and rolling out
  //Roll in
  public void blackhole() {
    rolliepollie.set(yoboimovin);
  }
  //Roll out
  public void whitehole() {
    rolliepollie.set(backupbro);
  }

  //stopping
  public void caviera() {
    rolliepollie.set(iguessillstop);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }






}
