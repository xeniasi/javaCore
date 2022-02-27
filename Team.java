public class Team {

    String teamName;
    Members[] teamMembers;

    Team (String teamName, Members[] teamMembers) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public void getTeamInfo() {
        System.out.println("Team Name: " + teamName + ". Team Members: ");
            for (int i = 0; i < teamMembers.length; i++) {
                System.out.println(teamMembers[i].getFullInfo());
            }
    }

    public Members[] getMembers(){
        return teamMembers;
    }

    public void passedTheDistance() {
        for (Members members : teamMembers) {
            if (members.isOnDistance()) {
                members.info();
            }
        }
    }

    public void showResults() {
        for (Members c : teamMembers) {
            c.info();
        }
    }
}
