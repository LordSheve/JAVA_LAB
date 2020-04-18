package theme3;

import theme3.students.types.Type;
import theme3.tasks.Teachers;
import theme3.tasks.StudentGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        StudentGenerator studentGenerator = new StudentGenerator(tunnel, 10);

        Teachers teachers1 = new Teachers(tunnel, Type.OOP);
        Teachers teachers2 = new Teachers(tunnel, Type.PHYSICS);
        Teachers teachers3 = new Teachers(tunnel, Type.MATHS);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(studentGenerator);
        service.execute(teachers1);
        service.execute(teachers2);
        service.execute(teachers3);

        service.shutdown();


    }
}