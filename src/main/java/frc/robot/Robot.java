package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  DriveTrain dt;
  Joystick joy;
  @Override
  public void robotInit() {
	  dt = new DriveTrain(1,2,3,4);
	  joy = new Joystick(0);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
	  dt.drive(joy.getX(), joy.getY(), joy.getTwist());
	  Timer.delay(0.1);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
