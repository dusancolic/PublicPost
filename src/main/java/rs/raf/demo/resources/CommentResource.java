package rs.raf.demo.resources;

import rs.raf.demo.entities.Comment;
import rs.raf.demo.entities.Post;
import rs.raf.demo.services.CommentService;
import rs.raf.demo.services.PostService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/comments")

public class CommentResource {

    @Inject
    private CommentService commentService;



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Comment create(@Valid Comment comment) {
        return this.commentService.addComment(comment);
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        return Response.ok(this.commentService.findComment(id)).build();
    }

}
