package theme3.tasks;

import theme3.students.types.Type;
import theme3.students.types.Size;
import theme3.students.Student;
import theme3.Tunnel;

import java.util.Random;

public class StudentGenerator implements Runnable {
    private Tunnel tunnel;
    private int studentCount;

    public StudentGenerator(Tunnel tunnel, int studentCount) {
        this.tunnel = tunnel;
        this.studentCount = studentCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < studentCount) {
            Thread.currentThread().setName("Generator student");
            count++;
            tunnel.add(new Student(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
