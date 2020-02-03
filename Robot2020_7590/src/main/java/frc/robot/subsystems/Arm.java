/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   *
   */

  private final SpeedController m_armMotor;

  public Arm() {
    m_armMotor = new WPI_TalonSRX(ArmConstants.kMotorArm);
  
  }

  public void rotateArmUp(double vitessepos){
    m_armMotor.set(vitessepos);
  }
  
  public void rotateArmDown(double vitesseneg){
    m_armMotor.set(vitesseneg);
  }

  public void rotateArmStop(){
    m_armMotor.stopMotor();
  }
}
