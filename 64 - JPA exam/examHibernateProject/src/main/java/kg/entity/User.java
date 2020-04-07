package kg.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nick", nullable = false)
    private String nick;

    @Column(name = "liked")
    private Integer likedNumber;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Post> postList;

    @ManyToMany
    @JoinColumn(name="followers")
    private Set<User> followers;// = new HashSet<>();

    public User(String nick, List<Post> postList, Set<User> followers) {
        this.nick = nick;
        this.postList = postList;
        this.followers = followers;
    }

    public Integer like(User user, Integer postNumber){
        PostLike postLike = new PostLike(LocalDateTime.now());
        List<PostLike> likeList = user.getPostList().get(postNumber).getPostLikes();
        likeList.add(postLike);
        user.getPostList().get(postNumber).setPostLikes(likeList);
        return user.getPostList().get(postNumber).getPostLikes().size();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", postList=" + postList +
                ", followers=" + followers +
                '}';
    }
}
