package patterns.builder;

/**
 * Created by user on 14.06.2017.
 */
public class Student {

    private String name;
    private int age;
    private boolean gender;

    public Student(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public static class Builder {

        private String name;
        private int age;
        private boolean gender;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Builder setGender(boolean gender) {
            this.gender = gender;

            return this;
        }

        // new Student will not be created until data correct
        public Student buildStudent() throws Exception {
            if (0 == age) throw new Exception("age = 0");
            if (name.isEmpty()) throw new Exception("name is empty");

            return new Student(name, age, gender);
        }
    }
}
