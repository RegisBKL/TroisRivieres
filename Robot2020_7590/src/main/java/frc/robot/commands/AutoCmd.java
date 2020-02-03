/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class AutoCmd extends CommandBase {
  private final DoubleSupplier m_fwd;
  private final DoubleSupplier m_rot;
  private final DriveBase m_drivebase;

  /**
   * Creates a new AutoCmd.
   */
  public AutoCmd(DoubleSupplier fwd, DoubleSupplier rot, DriveBase drivebase) {
    m_fwd = fwd;
    m_rot = rot;
    m_drivebase = drivebase;
    addRequirements(m_drivebase);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_timer.reset();
    //m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.arcadeDrive(m_fwd.getAsDouble(), m_rot.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
