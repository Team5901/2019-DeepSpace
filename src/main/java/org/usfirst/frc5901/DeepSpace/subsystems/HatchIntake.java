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
public class HatchIntake extends Subsystem {
  private Compressor CompressorOne = new Compressor(0);
  private Solenoid SingleOne = new Solenoid(1);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  

  public void PistonIn(){
    System.out.println("PistonIn");
    SingleOne.set(true);
  }   

  public void PistonOut(){
    System.out.println("PistonOut");
    SingleOne.set(false);
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
