/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc5901.DeepSpace.subsystems.SolenoidState;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Forearm extends Subsystem implements SolenoidState {

  private WPI_TalonSRX ForearmMotor;

  public Forearm() {
    ForearmMotor=new WPI_TalonSRX(6);
    
    int sensorPos=0;
    ForearmMotor.setSelectedSensorPosition(sensorPos, 0,10);
    ForearmMotor.configForwardSoftLimitThreshold(10,0);
    ForearmMotor.configReverseSoftLimitThreshold(-10,0);
    ForearmMotor.configForwardSoftLimitEnable(true,0);
    ForearmMotor.configReverseSoftLimitEnable(true,0);

  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void RiseArm() {
    ForearmMotor.set(-0.2);
  }
   
  public void FallArm(){
    System.out.println("Sensor Pos:" + ForearmMotor.getSelectedSensorPosition());
   ForearmMotor.set(0.2);
  }

  public void StopArm(){
    System.out.println("Sensor Pos:" + ForearmMotor.getSelectedSensorPosition());
    ForearmMotor.set(0.0);
  }
}