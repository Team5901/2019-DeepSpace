// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5901.DeepSpace.subsystems;

import org.usfirst.frc5901.DeepSpace.Robot;
import org.usfirst.frc5901.DeepSpace.commands.*;
import org.usfirst.frc5901.DeepSpace.subsystems.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivetrain extends Subsystem implements MotorSpeeds{

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //VEX Victor SPX Motor Controller when used on CAN Bus.
    //Speed controller
    //Positioning for Robot
    private WPI_TalonSRX leftFront, leftRear, rightFront, rightRear;
    private SpeedControllerGroup m_left, m_right;
    private DifferentialDrive cougarDrive;
    private Encoder driveEncoder;
    private ADXRS450_Gyro driveGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private double leftMotorSpeed;
    private double rightMotorSpeed;
    private double move;
    private double rotate;

    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //VEX Victor SPX Motor Controller when used on CAN Bus.
        leftFront = new WPI_TalonSRX(1);
        leftRear = new WPI_TalonSRX(3);
        
        
        
        m_left = new SpeedControllerGroup(leftFront, leftRear  );
        addChild("m_left",m_left);
        
        
        rightFront = new WPI_TalonSRX(2);
        
        
        
        rightRear = new WPI_TalonSRX(4);
        
        
        
        m_right = new SpeedControllerGroup(rightFront, rightRear  );
        addChild("m_right",m_right);
        
        
        cougarDrive = new DifferentialDrive(m_left, m_right);
        addChild("CougarDrive",cougarDrive);
        cougarDrive.setSafetyEnabled(false);
        cougarDrive.setExpiration(0.1);
        cougarDrive.setMaxOutput(1.0);

        
        driveEncoder = new Encoder(0, 1, false, EncodingType.k1X);
        addChild("driveEncoder",driveEncoder);
        driveEncoder.setDistancePerPulse(0.0092);
        driveEncoder.setPIDSourceType(PIDSourceType.kRate);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DefaultDrive()); 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DefaultDrive());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //%%%%%%%%%% PARAMETERS %%%%%%%%%%
 	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
     double turnRatio = 0.03; 						//Higher = faster gyro turning, but more oscillation
     private static double precisionDriveAmount=0.7;    
    
     
     //%%%%%%%%%% Limits maximum turning rate %%%%%%%%%%
     private static double limitTurn(double num) {
         if (num > 0.5) {
             return 0.5;
         }
         else if (num < -0.5) {
             return -0.5;
         }
         else{
             return num;
         }
     }
          
     //%%%%%%%%%% Main driving command - has turbo button. Press for slower control %%%%%%%%%%
     public void drive(){
         
         move = Robot.oi.controller1.getRawAxis(1);
         rotate = Robot.oi.controller1.getRawAxis(4);             
         

         //Slow down if pistons are deployed
         if (Robot.lift.RearOne.get() || Robot.lift.MiddlesoulSolenoid.get()){
            cougarDrive.arcadeDrive(slowDrive*move, slowDrive*rotate, true);

            //Right bumper = drive slower
            if (Robot.oi.controller1.getRawButton(6)){
                cougarDrive.arcadeDrive(slowDrive*move, slowDrive*rotate, true);
            }

            //Right Trigger = slowly turn right
            else if (Robot.oi.controller1.getRawAxis(3) > 0.3){
                cougarDrive.arcadeDrive(0, slowDrive, true);
            }
            
            //Left Trigger = slowly turn left
            else if (Robot.oi.controller1.getRawAxis(3) < -0.3){
                cougarDrive.arcadeDrive(0, -slowDrive, true);
            }
            //Default - drive normally
            else{					
                cougarDrive.arcadeDrive(move, rotate, true);
            }	
        }	
     }
     
     //%%%%%%%%%% Stops all motors %%%%%%%%%%
     public void stopDrive(){
         cougarDrive.arcadeDrive(0.0,0.0,true);
     }
     
     //%%%%%%%%%% Turn to an angle in autonomous %%%%%%%%%%
     public void autoTurn(double angleTarget){
         double angle = driveGyro.getAngle(); 						// get current heading
         double target = angle + angleTarget;
         
         if( target < -1 || target > 1) {	
            cougarDrive.arcadeDrive(0.0, -limitTurn((target)*turnRatio)-Math.signum(target)*.07,true); 		// turn towards angleTarget
             Timer.delay(0.004);	    
         }
     }
     
     //%%%%%%%%%% Drive backwards in autonomous %%%%%%%%%%
     public void autoBackwards(double speed){
          double angle = driveGyro.getAngle(); 				// get current heading
          cougarDrive.arcadeDrive(speed, -angle*turnRatio,true); 					// drive backwardsheading 0
          Timer.delay(0.004);
     }
     
     //%%%%%%%%%% Drive straight in autonomous %%%%%%%%%%
     public void autoStraight(double speed){
          double angle = driveGyro.getAngle(); 				// get current heading
          cougarDrive.arcadeDrive(-speed, -angle*turnRatio,true); 				// drive towards heading 0
          Timer.delay(0.004);
     }
     
     public void autoaim() {
         NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
         NetworkTableEntry tx = table.getEntry("tx");
         NetworkTableEntry ta = table.getEntry("ta");		
         NetworkTableEntry tv = table.getEntry("tv");
         
         double x = tx.getDouble(0);
         double area = ta.getDouble(0);
         double targetExist = tv.getDouble(0);
         
         System.out.println("Attempting Autoaim..." + targetExist);
         //if (targetExist==1) {
             if( x < -1 || x > 1) {
                 System.out.println("AutoAim: "+ x);
                 cougarDrive.arcadeDrive(0.2,limitTurn(x*.04)+Math.signum(x)*.07,true); 						// turn towards angleTarget
                 Timer.delay(0.004);	   
             }
         /*}
         else {
             System.out.println("TargetDoesntExist: "+ x);
             
         }*/
             
         
 
     
	}

}

