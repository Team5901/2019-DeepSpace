/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Forearm extends Subsystem implements MotorSpeeds{

  private WPI_TalonSRX ForearmMotor;

  public Forearm() {
    ForearmMotor=new WPI_TalonSRX(6);

  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void RiseArm() {
    ForearmMotor.set(wristUpSpeed);
  }
   
  public void FallArm(){
   ForearmMotor.set(wristDownSpeed);
  }

  public void StopArm(){
    ForearmMotor.set(0.0);
  }
}