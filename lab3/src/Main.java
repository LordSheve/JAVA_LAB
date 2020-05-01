import factory.ExamTaker;
import generator.StudentsGenerator;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
//    StudentsGenerator studentsGenerator = new StudentsGenerator(40);
//    Thread thread = new Thread(studentsGenerator);
//    thread.run();

        ExamTaker examTaker = new ExamTaker(30);
        examTaker.takeExam();
    }
}
