package stackoverflow.entities;

import stackoverflow.enums.VoteType;

public class Vote {
    public final User voter;
    public final VoteType voteType;

    public Vote(User voter, VoteType voteType) {
        this.voter = voter;
        this.voteType = voteType;
    }
}
