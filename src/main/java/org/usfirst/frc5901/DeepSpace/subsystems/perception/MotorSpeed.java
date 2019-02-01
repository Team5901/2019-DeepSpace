package org.usfirst.frc5901.DeepSpace.subsystems.perception;

public interface MotorSpeed {

    //getter for MotorSpeed
    double getMotorSpeed();

    //setter for single motor
    void setMotorSpeed(double motorSpeed);
    //setter for two motors
    void setMotorSpeed(double leftMotorSpeed, double rightMotorSpeed);

}