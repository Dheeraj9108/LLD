package LinkedinLLD.stratergy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import LinkedinLLD.entites.Post;

public class ChronicalsortStratergy implements FeedSortStratergy{

    @Override
    public List<Post> sort(List<Post> posts) {
        return posts.stream()
            .sorted(Comparator.comparing(Post::getCreatedDate).reversed())
            .collect(Collectors.toList());
    }

}
