/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class DriveBase extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private  final SpeedController m_rightFront;
  private  final SpeedController m_rightRear;
  private  final SpeedController m_leftFront;
  private  final SpeedController m_leftRear;

  private final SpeedControllerGroup m_leftSide;
  private final SpeedControllerGroup m_rightSide;


  
  private final DifferentialDrive m_diffDrive;


  public DriveBase(){

    m_rightFront = new WPI_TalonSRX(DriveConstants.kRightMotor1Port);
    m_rightRear = new WPI_VictorSPX(DriveConstants.kRightMotor2Port);
    m_leftFront = new WPI_TalonSRX(DriveConstants.kLeftMotor1Port);
    m_leftRear = new WPI_VictorSPX(DriveConstants.kLeftMotor2Port);

 /* Important:  flip values so robot moves forward when stick-forward/LEDs-green */
    m_rightFront.setInverted(true); // !< Update this based on your motor
    m_rightRear.setInverted(true); // !< Update this based on your motor
    m_leftFront.setInverted(true); // !< Update this based on your motor
    m_leftRear.setInverted(true); // !< Update this based on your motor

    m_leftSide = new SpeedControllerGroup(m_leftFront, m_leftRear);
    m_rightSide = new SpeedControllerGroup(m_rightFront,  m_rightRear);

    m_diffDrive = new DifferentialDrive(m_leftSide, m_rightSide);

    addChild("Drivebase", m_diffDrive);
  }

 
  public void arcadeDrive (double DriveSpeed, double DriveRotation) {
    m_diffDrive.arcadeDrive(DriveSpeed, DriveRotation);
  }

  public void tankDrive (double DriveLeftSpeed, double DriveRightSpeed) {
    m_diffDrive.tankDrive(DriveLeftSpeed, DriveRightSpeed);
  }

}

