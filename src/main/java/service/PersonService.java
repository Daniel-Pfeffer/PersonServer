package service;

import entity.Person;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import repository.Repository;

@Path("persons")
public class PersonService {


    // Show message 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("message")
    public String message() {
        return " Hello REST Service powered by Java SE ";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAll")
    public List<Person> findAll() {
        return Repository.getInstance().findAll();
    }

    @Path("insert")
    @POST
    public void insert(Person person) throws IOException {
        Repository repo = Repository.getInstance();
        repo.insert(person);
        findAll();
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") int id) throws IOException {
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


}
