/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;

import frc.robot.commands.ArmCmd;
import frc.robot.commands.AutoCmd;
import frc.robot.commands.DriveCmd;
import frc.robot.commands.LancerCmd;
import frc.robot.commands.StopArmCmd;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;

import static java.util.Map.entry;
import java.util.Map;
import edu.wpi.first.wpilibj2.command.SelectCommand;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private enum CommandSelector{
    ONE,TWO,THREE
  }
  public DriveBase m_drivebase = new DriveBase();

  private final Arm m_arm = new Arm();

  private CommandSelector select(){
    return CommandSelector.ONE; 
  }

  private final Command selectCommand =
    new SelectCommand(
        //Maps selector values to commands
        Map.ofEntries(
            entry(CommandSelector.ONE,new Autonomous(m_drivebase)),
            entry(CommandSelector.TWO,new PrintCommand("Command two was selected")),
            entry(CommandSelector.THREE,new PrintCommand("Command three was selected"))

        ),
        this::select
    );
    private final Command m_autoCommand1 = new AutoCmd(()->0.5, ()->0, m_drivebase).withTimeout(1.0).andThen(new AutoCmd(()->0, ()->0.5, m_drivebase).withTimeout(1.5),
                                        new AutoCmd(()->0.5, ()->0, m_drivebase).withTimeout(1.0),new AutoCmd(()->0, ()->0, m_drivebase).withTimeout(1.0)) ;
    private final Command m_autoCommand2 = new Autonomous(m_drivebase);
  

  private final Joystick m_joystick = new Joystick(OIConstants.kPortJoystick);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
        // Configure the button bindings
    configureButtonBindings();
    m_drivebase.setDefaultCommand(new DriveCmd(() -> m_joystick.getY(), () -> m_joystick.getX(), m_drivebase));
    m_arm.setDefaultCommand(new StopArmCmd(m_arm));
    
  }



  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_joystick , 4).whileHeld(new ArmCmd(()->0.2, m_arm));
    new JoystickButton(m_joystick , 3).whileHeld(new ArmCmd(()->-0.2, m_arm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return selectCommand; //pour choisir une commande parmi d'autres (selectionner une commande)
   // return m_autoCommand1; // pour executer une seule commande 
   // return m_autoCommand2;  // pour executer une commande 
  }

}
