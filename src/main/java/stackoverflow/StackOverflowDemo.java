package stackoverflow;

import stackoverflow.entities.Answer;
import stackoverflow.entities.Question;
import stackoverflow.entities.Tag;
import stackoverflow.entities.User;
import stackoverflow.enums.VoteType;
import stackoverflow.strategies.SearchStrategy;
import stackoverflow.strategies.TagSearchStrategy;

import java.util.List;
import java.util.Set;

public class StackOverflowDemo {
    public static void main(String[] args) {
        StackOverflowService service = new StackOverflowService();
        User user1 = service.addUser("Bhagwat");
        User user2 = service.addUser("ABC");
        User user3 = service.addUser("XYZ");

        System.out.println("User1 is " + user1.getName());

        Question question1 = service.addQuestion(user1.getId(), "HLO WORLD", "Hello", Set.of(new Tag("Design")));
        System.out.println("Question1 is " + question1.getTitle());

        Answer answer1 = service.postAnswer(user2.getId(), "OK", "Makes sense", question1.getId());
        System.out.println("Answer1 is " + answer1.getDescription());

        System.out.println("Reputation for Bhagwat is " + user1.getReputation());
        service.voteOnPost(question1.getId(), VoteType.DOWNVOTE);
        System.out.println("Reputation for Bhagwat is " + user1.getReputation());

        SearchStrategy tagSearchStrategy1 = new TagSearchStrategy(new Tag("HLO"));
        SearchStrategy tagSearchStrategy2 = new TagSearchStrategy(new Tag("Design"));

        System.out.println(tagSearchStrategy1.find(List.of(question1)));
        System.out.println(tagSearchStrategy2.find(List.of(question1)));
    }
}
