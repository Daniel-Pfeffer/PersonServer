package service;

import entity.Person;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import repository.Repository;

@Path("persons")
public class PersonService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAll")
    public List<Person> findAll() {
        return Repository.getInstance().findAll();
    }

    @Path("insert")
    @POST
    public void insert(Person person) {
        Repository repo = Repository.getInstance();
        repo.insert(person);
        findAll();
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") int id) {
        Repository repo = Repository.getInstance();
        repo.delete(id);
    }

    @GET
    @Path("restart")
    public void restart() {
        Repository repo = Repository.getInstance();
        repo.restart();
    }

    @POST
    @Path("update/{id}")
    public void update(@PathParam("id") int id, Person person) throws IOException {
        Repository repo = Repository.getInstance();
        repo.update(person, id);
    }

    @GET
    @Path("find")
    public List<Person> find(@QueryParam("page") int page, @QueryParam("size") int size){
        Repository repo = Repository.getInstance();
        return repo.find(page, size);
    }

    @GET
    @Path("count")
    public int count(){
        Repository repo = Repository.getInstance();
        return repo.count();
    }

}
