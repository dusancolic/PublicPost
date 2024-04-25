package rs.raf.demo.repositories.subject;

import rs.raf.demo.entities.Post;

import java.util.List;

public interface PostRepository {
    public Post addSubject(Post subject);
    public List<Post> allSubjects();
    public Post findSubject(Integer id);
}
