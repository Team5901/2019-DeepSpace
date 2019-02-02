/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5901.DeepSpace.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class HatchIntake extends Subsystem {
  private WPI_VictorSPX HatchIntakeMotor= new WPI_VictorSPX(0);
  private Compressor CompressorOne = new Compressor(0);
  private Solenoid SolenoidOne = new Solenoid(0);
  private DoubleSolenoid DoubleOne = new DoubleSolenoid(0, 0);

  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
   
  
   public void PistonIn(){

    SolenoidOne.set(true);
    SolenoidOne.set(false);

  }
  public void StopIntakeIn(){
  }
  public void CompressorOn(){
    CompressorOne.setClosedLoopControl(true);
  }
  public void CompressorOff(){
    CompressorOne.setClosedLoopControl(false);
  }
    @Override

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
