package rs.raf.demo;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import rs.raf.demo.repositories.comment.CommentRepository;
import rs.raf.demo.repositories.comment.InMemoryCommentRepository;
import rs.raf.demo.repositories.subject.InMemoryPostRepository;
import rs.raf.demo.repositories.subject.PostRepository;
import rs.raf.demo.services.CommentService;
import rs.raf.demo.services.PostService;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        // Ukljucujemo validaciju
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // Definisemo implementacije u dependency container-u
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(InMemoryPostRepository.class).to(PostRepository.class).in(Singleton.class);

                this.bindAsContract(PostService.class);
                this.bind(InMemoryCommentRepository.class).to(CommentRepository.class).in(Singleton.class);

                this.bindAsContract(CommentService.class);
            }
        };
        register(binder);

        // Ucitavamo resurse
        packages("rs.raf.demo.resources");
    }
}
