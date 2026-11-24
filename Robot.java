package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeShooterSubsystem;

public class Robot extends TimedRobot {
    
    private final Joystick joystick = new Joystick(0);
    private Command autonomousCommand;
    private RobotContainer robotContainer;
 
    private final Timer tempo = new Timer();

    private final IntakeShooterSubsystem intakeShooterSubsystem = new IntakeShooterSubsystem();
    private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
    
    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
    }
    
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        drivetrainSubsystem.updateDashboard();
    }
    
    @Override
    public void autonomousInit() {
        drivetrainSubsystem.resetEncoders();

        if (robotContainer != null) {
            autonomousCommand = robotContainer.getAutonomousCommand();
            if (autonomousCommand != null) {
                System.out.println("Executando modo autonomo: " + autonomousCommand.getName());
                autonomousCommand.schedule();
            } else {
                System.out.println("Nenhum comando autonomo foi selecionado.");
            }
        } else {
            System.out.println("robotContainer é nulo!");
        }
    }
    
    @Override
    public void autonomousPeriodic() {
    
    }
    
    @Override
    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
        tempo.reset();
        tempo.start();
    }

    @Override
    public void teleopPeriodic() {
        operateIntakeShotter();
        controlMovement();
    }

    private void operateIntakeShotter() {
        boolean collect = joystick.getRawButton(Constants.ButtonConstants.button_collect);
        boolean shooter = joystick.getRawButton(Constants.ButtonConstants.button_shooter);
        intakeShooterSubsystem.operateIntakeShotter(collect, shooter);
    }

    private void controlMovement() {
        double speed = joystick.getRawAxis(Constants.AxisConstants.axis_speed);
        double rotation = joystick.getRawAxis(Constants.AxisConstants.axis_rotation);
        double controler = joystick.getRawAxis(Constants.AxisConstants.axis_controler_velocity);
        boolean brake = joystick.getRawButton(Constants.ButtonConstants.button_brake);
        drivetrainSubsystem.operateDrive(speed, rotation, controler, brake);
    }

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {}

    @Override
    public void testInit() {}

    @Override
    public void testPeriodic() {}

    @Override
    public void simulationInit() {}

    @Override
    public void simulationPeriodic() {}
}