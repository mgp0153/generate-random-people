public class Person {
    private String sex;
    private String nationality;
    private String name;
    private int age;
    private double weight;
    private double height;
    private String blood;

    public Person(String sex, String nationality, String name, int age, double weight, double height, String blood){
        this.sex = sex;
        this.nationality = nationality;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.blood = blood;
    }

    public String getSex() {
        return sex;
    }

    public String getNationality() {
        return nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getBlood() {
        return blood;
    }
}
