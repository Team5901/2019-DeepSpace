/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.usfirst.frc5901.DeepSpace.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5901.DeepSpace.commands.*;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX leftElevatorMotor;
  private WPI_TalonSRX rightElevatorMotor;

  public Elevator(){

    leftElevatorMotor = new WPI_TalonSRX(5);
    rightElevatorMotor = new WPI_TalonSRX(7);

    int sensorPos=0;
    leftElevatorMotor.setSelectedSensorPosition(sensorPos, 0,10);
    //rightElevatorMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower, 5);
    //leftElevatorMotor.configForwardSoftLimitThreshold(10000,0);
    //leftElevatorMotor.configReverseSoftLimitThreshold(0,0);
    leftElevatorMotor.configForwardSoftLimitEnable(false, 0);
    leftElevatorMotor.configReverseSoftLimitEnable(false, 0);
  }

  public void elevatorStop(){
    leftElevatorMotor.set(0.0);
    rightElevatorMotor.set(0.0);
  }

  public void elevatorUp(){
    leftElevatorMotor.set(-0.4);
    rightElevatorMotor.set(-0.4);
  }

  public void elevatorDown(){
    leftElevatorMotor.set(0.3);
    rightElevatorMotor.set(0.3);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()
    
    
    
    
    
    
    
    
  }
}
