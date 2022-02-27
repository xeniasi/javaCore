public class Swimming extends Obstacle {

    private int swimDistance;

    public Swimming(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    @Override
    public void doIt(Members Member) {
        Member.swim(swimDistance);
    }
}
