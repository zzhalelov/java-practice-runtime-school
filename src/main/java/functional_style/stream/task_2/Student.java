package functional_style.stream.task_2;

public class Student {
    String surname;
    String name;
    String email;
    int entranceYear;
    String groupName;

    public Student(String surname, String name, String email, int entranceYear) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", entranceYear=" + entranceYear +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    //students хранит фамилию и имя как две отдельные строки, examPassedNames хранит всё в одном поле String
    //для сравнения students и examPassedNames необходимо объединить фамилию и имя в students
    public String getName() {
        return surname + " " + name;
    }

    public String getEmail() {
        return email;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}