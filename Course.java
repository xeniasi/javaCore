public class Course {

    Obstacle[] obstacles;

    Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        Members[] teamMembers = team.getMembers();
        if(teamMembers.length > 0){
            for (Members c: teamMembers){
                for (Obstacle o: obstacles){
                    o.doIt(c);
                }
            }
        } else {
            System.out.println("There are no members in the team!");
        }
    }

}
