package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.AutonomousSubsystem;

public class AutonomousDiagonal extends SequentialCommandGroup {

    /* A função AutonomousDiagonal deve ser escolhida no elastic apenas quando o robô estiver posicionado na diagonal da arena */
    public AutonomousDiagonal(AutonomousSubsystem autonomousSubsystem) {
        addCommands(
            new InstantCommand(() -> autonomousSubsystem.moveFrente(0.3), autonomousSubsystem),
            new WaitCommand(2.5),

           new InstantCommand(() -> autonomousSubsystem.moveFrente(0.3), autonomousSubsystem),
            new WaitCommand(2.0),

            new InstantCommand(() -> autonomousSubsystem.stopMotors(), autonomousSubsystem),

            new InstantCommand(() -> autonomousSubsystem.ligarIntake(1.0), autonomousSubsystem),
            new InstantCommand(() -> autonomousSubsystem.ligarShooter(1.0), autonomousSubsystem),
            
            new WaitCommand(3.0),

            new InstantCommand(() -> autonomousSubsystem.desligarIntake(), autonomousSubsystem), 
            new InstantCommand(() -> autonomousSubsystem.desligarShooter(), autonomousSubsystem)
       

        );
    }
}