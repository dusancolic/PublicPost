package rs.raf.demo.services;

import rs.raf.demo.entities.Post;
import rs.raf.demo.repositories.subject.PostRepository;

import javax.inject.Inject;
import java.util.List;


public class PostService {

    public PostService() {
        System.out.println(this);
    }

    @Inject
    private PostRepository subjectRepository;

    public Post addSubject(Post subject) {
        return this.subjectRepository.addSubject(subject);
    }

    public List<Post> allSubjects() {
        return this.subjectRepository.allSubjects();
    }

    public Post findSubject(Integer id) {
        return this.subjectRepository.findSubject(id);
    }
}
