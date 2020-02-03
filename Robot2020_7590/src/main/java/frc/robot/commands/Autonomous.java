/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveBase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Autonomous extends SequentialCommandGroup {
  private DriveBase m_drivebase;

/**
   * Creates a new Autonomous.
   */
  public Autonomous(DriveBase driveBase) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    m_drivebase = driveBase;
    addCommands(
        new AutoCmd(()->0.5, ()->0, m_drivebase).withTimeout(1.0),new AutoCmd(()->0, ()->0.5, m_drivebase).withTimeout(1.5),
        new AutoCmd(()->0.5, ()->0, m_drivebase).withTimeout(1.0),new AutoCmd(()->0, ()->0.5, m_drivebase).withTimeout(1.0)) ;

  }
}
