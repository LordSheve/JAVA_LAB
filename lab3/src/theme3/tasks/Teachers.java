package theme3.tasks;

import theme3.Tunnel;
import theme3.students.Student;
import theme3.students.types.Type;

public class Teachers implements Runnable {
    private Tunnel tunnel;
    private Type studentType;

    public Teachers(Tunnel tunnel, Type studentType) {
        this.tunnel = tunnel;
        this.studentType = studentType;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Subject: " + studentType);

                Student student = tunnel.get(studentType);
                if (student != null)
                while (student.countCheck()) {
                    //использую sleep только для эмуляции работы студентов(нужно время чтоб студенты пришли)
                    Thread.sleep(100);
                    student.add(5);
                    System.out.println(student.getCount() + " Jobs verified " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
