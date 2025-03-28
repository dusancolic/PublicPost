package rs.raf.demo.services;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;
import rs.raf.demo.repositories.comment.CommentRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.List;


public class CommentService {
    public CommentService() {
        System.out.println(this);
    }

    @Inject
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return this.commentRepository.addComment(comment);
    }

    public List<Comment> findComment(Integer id) {
        return this.commentRepository.findCommentWithPostId(id);
    }
}
