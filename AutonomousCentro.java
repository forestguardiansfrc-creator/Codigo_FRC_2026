package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.AutonomousSubsystem;

public class AutonomousCentro extends SequentialCommandGroup {

    /* A função AutonomousCentro deve ser escolhida no elastic apenas quando o robô estiver posicionado no centro da arena */
    public AutonomousCentro(AutonomousSubsystem autonomousSubsystem) {
        addCommands(
            
            /* Mude esses comandos conforme a necessidade, todas as funções presentes no robô já estão configuradas no
             * autonomousSubsystem.
             * 
             * Ex: Não quero que o meu robô vá para frente (como está no primeiro comando) quero que vá para trás
             * O command ficaria assim: new InstantCommand(() -> autonomousSubsystem.moveTrás(0.3), autonomousSubsystem),
             * 
             * new WaitCommand() é uma função que determina o tempo de espera para a execução do próximo command.
             * Se não tiver a presença dele na linha abaixo do command, o próximo vai executar automaticamente sem espera.
             */

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