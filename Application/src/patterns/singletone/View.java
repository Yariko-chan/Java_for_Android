package patterns.singletone;

/**
 * Created by user on 21.06.2017.
 */
public class View {
    public static void main(String[] args) {

        Gender m = Gender.M; // всегда для всезх один и тот же объект
        Gender m2 = Gender.M; // = m
        // enum создает сам для нас объекты, но он создаёт ровно столько объектов, сколько у нас в перечислении
        Gender w = Gender.W;
    }
}
