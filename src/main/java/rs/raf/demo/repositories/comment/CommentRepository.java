package rs.raf.demo.repositories.comment;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;

import java.util.List;

public interface CommentRepository {
    Comment addComment(Comment comment);

    List<Comment> allComments();

    List<Comment> findCommentWithPostId(Integer id);
}
