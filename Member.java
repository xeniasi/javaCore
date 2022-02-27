public class Member implements Members {

    String name;
    int age;
    int maxRunDistance;
    int maxSwimDistance;
    boolean onDistance;

    Member(String name, int age, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.age = age;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public String getFullInfo() {
        return "Member name " + this.name + ", member age " + this.age;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void run(int runDistance){
        if (runDistance <=maxRunDistance){
            System.out.println(name + " successfully ran");
        } else {
            System.out.println(name + " couldn't run");
            onDistance = false;
        }
    }

    @Override
    public void swim(int swimDistance){
        if (swimDistance <=maxSwimDistance){
            System.out.println(name + " successfully swam");
        } else {
            System.out.println(name + " couldn't swim");
            onDistance = false;
        }
    }

    @Override
    public void info() {
        if (onDistance == true){
            System.out.println(name + " has passed all obstacles");
        } else {
            System.out.println(name + " couldn't passed all obstacles");
        }
    }

}
