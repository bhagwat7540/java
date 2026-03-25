package stackoverflow.enums;

public enum EventType {
    QUESTION_UPVOTE(5),
    QUESTION_DOWNVOTE(-5),
    ANSWER_UPVOTE(3),
    ANSWER_DOWNVOTE(-3);
    private int points;

    EventType(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
