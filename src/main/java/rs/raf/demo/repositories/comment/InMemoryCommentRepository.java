package rs.raf.demo.repositories.comment;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InMemoryCommentRepository implements CommentRepository{
    private static List<Comment> comments = new CopyOnWriteArrayList<>();

    @Override
    public Comment addComment(Comment comment) {
        comment.setId(comments.size());
        System.out.println(comment.getPostId());
         comments.add(Math.toIntExact(comments.size()),comment);
         return comment;
    }

    @Override
    public List<Comment> findCommentWithPostId(Integer id) {
        return comments.stream().filter(comment -> comment.getPostId().equals(id)).collect(Collectors.toList());
    }

}
