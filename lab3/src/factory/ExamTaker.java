package factory;

import generator.StudentsGenerator;
import generator.SubjectName;
import robots.Robot;

public class ExamTaker {
    Robot mathRobot;
    Robot physicRobot;
    Robot oopRobot;
    Cabinet cabinet;
    StudentsGenerator studentsGenerator;

    public ExamTaker(int studentsNumber) {
        cabinet = new Cabinet(studentsNumber);
        studentsGenerator = new StudentsGenerator(studentsNumber, cabinet);

        mathRobot = new Robot(SubjectName.MATH, cabinet);
        physicRobot = new Robot(SubjectName.PHYSIC, cabinet);
        oopRobot = new Robot(SubjectName.OOP, cabinet);


    }

    public void takeExam() {
        Thread mathRobotThread = new Thread(mathRobot);
        Thread physicRobotThread = new Thread(physicRobot);
        Thread oopRobotThread = new Thread(oopRobot);
        Thread generatorThread = new Thread(studentsGenerator);

        mathRobotThread.start();
        physicRobotThread.start();
        oopRobotThread.start();
        generatorThread.start();


    }
}
