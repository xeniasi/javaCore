public class Main {

    public static void main(String[] args) {

        Members[] members = {new Member("Alex", 23, 600, 350), new Member("Nick", 25, 350, 150), new Member("Sabrina", 23, 600, 150), new Member("John", 22, 550, 300)};
        Team team = new Team("Dream Team", members);

        Obstacle[] obstacles = {new Running(500), new Swimming(300)};
        Course c = new Course(obstacles);

        team.getTeamInfo();
        System.out.println();

        System.out.println("Team starts:");
        c.doIt(team);
        System.out.println();

        System.out.println("Winners:");
        team.passedTheDistance();
        System.out.println();

        System.out.println("Team Results:");
        team.showResults();

    }

}
