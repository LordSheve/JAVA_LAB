package theme3;

import theme3.students.Student;
import theme3.students.types.Type;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {

    private List<Student> store;
    private static final int maxStudentInTunnel = 10;
    private static final int minStudentInTunnel = 0;
    private int studentCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Student element) {

        try {
            if (studentCounter < maxStudentInTunnel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + The student arrived in the tunnel: %s %s %s", store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                studentCounter++;

            } else {
                System.out.println(store.size() + "> There is no place for a student in the tunnel: " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Student get(Type studentType) {

        try {
            if (studentCounter > minStudentInTunnel) {
                notifyAll();
                for (Student student : store) {
                    if (student.getType() == studentType) {
                        studentCounter--;
                        System.out.println(store.size() + "- The student is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(student);
                        return student;
                    }
                }
            }

            System.out.println("0 < There are no students in the tunnel");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
