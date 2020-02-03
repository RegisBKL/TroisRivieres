/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.LanceurConstants;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lanceur extends SubsystemBase {
  private SpeedController m_lanceurGauche;
  private SpeedController m_lanceurDroit;

  /**
   * Creates a new Protolanceursub.
   */
  public Lanceur() {
    m_lanceurDroit = new WPI_TalonSRX(LanceurConstants.kMotorDroitLanceur);
    m_lanceurGauche = new WPI_TalonSRX(LanceurConstants.kMotorGaucheLanceur);
  }

  public void lancer(){
    m_lanceurGauche.set(LanceurConstants.kVitesseGaucheLanceur);
    m_lanceurDroit.set(LanceurConstants.kVitesseDroitLanceur);
  }

  public void stopLanceur(){
    m_lanceurGauche.stopMotor();
    m_lanceurDroit.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
