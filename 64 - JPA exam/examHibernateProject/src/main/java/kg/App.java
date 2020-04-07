package kg;

import kg.db.GenericsDB;
import kg.entity.Post;
import kg.entity.PostLike;
import kg.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        PostLike like1 = new PostLike(LocalDateTime.now());
        PostLike like2 = new PostLike(LocalDateTime.now());
        GenericsDB<PostLike> postLikeDB = new GenericsDB<>();
        postLikeDB.create(like1);
        postLikeDB.create(like2);
        List<PostLike> likeList = new ArrayList<>();
        likeList.add(like1);
        likeList.add(like2);

        List<PostLike> likeList2 = new ArrayList<>();
        Post post1 = new Post("cool weather!", LocalDateTime.now(), likeList);
        Post post2 = new Post("dinner with friends", LocalDateTime.now(), likeList2);
        GenericsDB<Post> postDB = new GenericsDB<>();
        postDB.create(post1);
        postDB.create(post2);
        List<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);

        Set<User> userSet = new HashSet<>();

        User user1 = new User("alexBieber", postList, userSet);
        GenericsDB<User> userDB = new GenericsDB<>();
        userDB.create(user1);

        //----------------------------------------------------------------------------

        PostLike like3 = new PostLike(LocalDateTime.now());
        postLikeDB.create(like3);
        List<PostLike> likeList1User2 = new ArrayList<>();
        likeList1User2.add(like3);

        Post post1User2 = new Post("cool weather!", LocalDateTime.now(), likeList1User2);
        postDB.create(post1User2);
        List<Post> postList1User2 = new ArrayList<>();
        postList1User2.add(post1User2);

        Set<User> followersUser2 = new HashSet<>();

        User user2 = new User("john007", postList1User2, followersUser2);
        userDB.create(user2);

        user2.like(user1,1);  //user2 liked user1's 1-post
        user2.setLikedNumber(user2.getLikedNumber()+1);

        //---------------------------------------------------------------------------


    }
}
