package rs.raf.demo.repositories.subject;

import rs.raf.demo.entities.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryPostRepository implements PostRepository {
    private static List<Post> subjects = new CopyOnWriteArrayList<>();

    public InMemoryPostRepository() {
        System.out.println(this);
    }

    @Override
    public synchronized Post addSubject(Post subject) {
        Integer id = subjects.size();
        subject.setId(id);
        subjects.add(Math.toIntExact(id), subject);

        return subject;
    }

    @Override
    public List<Post> allSubjects() {
        return new ArrayList<>(subjects);
    }

    @Override
    public Post findSubject(Integer id) {
        return subjects.get(id);
    }
}
