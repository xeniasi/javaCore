public class Running extends Obstacle {

    private int runDistance;

    public Running(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public void doIt(Members Member) {
        Member.run(runDistance);
    }
}

