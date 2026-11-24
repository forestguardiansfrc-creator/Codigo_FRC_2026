package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.AutonomousCentro;
import frc.robot.commands.AutonomousDiagonal;
import frc.robot.subsystems.AutonomousSubsystem;

public class RobotContainer {

    private final AutonomousSubsystem autonomousSubsystem = new AutonomousSubsystem();
    private final SendableChooser<Command> autonomousChooser = new SendableChooser<>();

    // Comandos autônomos
    private final Command autonomousCentro;
    private final Command autonomousDiagonal;
    private final Command autonomousNone;

    public RobotContainer() {
        // Inicializa os comandos uma única vez
        autonomousCentro = new AutonomousCentro(autonomousSubsystem);
        autonomousDiagonal = new AutonomousDiagonal(autonomousSubsystem);
        autonomousNone = new InstantCommand();


        // Adiciona as opções de rotina autônoma ao chooser
        autonomousChooser.setDefaultOption("Nenhum", autonomousNone);
        autonomousChooser.addOption("Centro", autonomousCentro);
        autonomousChooser.addOption("Diagonal", autonomousDiagonal);


        // Publica no SmartDashboard
        SmartDashboard.putData("Selecione o Autonomo", autonomousChooser);
    }

    public Command getAutonomousCommand() {
        Command selectedCommand = autonomousChooser.getSelected();
        return selectedCommand;
    }
}