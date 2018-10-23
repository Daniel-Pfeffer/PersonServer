package repository;

import entity.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @author H. Lackinger
 */
public class Repository {

    private static Repository instance = null;

    // Person Collection
    LinkedList<Person> persons = new LinkedList<>();
    private Path path = Paths.get("rest.csv");

    private Repository() {
        loadFromFile();
    }

    public static Repository getInstance() {
        if (instance == null)
            instance = new Repository();

        return instance;
    }


    public List<Person> findAll() {
        return persons;
    }

    public void loadFromFile() {
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {

                String[] splitArray = line.split(";");

                Person newPerson = new Person(
                        Integer.parseInt(splitArray[0]),
                        splitArray[1],
                        splitArray[2],
                        splitArray[3],
                        splitArray[4],
                        splitArray[5],
                        Integer.parseInt(splitArray[6]),
                        Boolean.valueOf(splitArray[7]));
                persons.add(newPerson);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void insert(Person person) {
        persons.add(person);
        writeFile();
    }

    public void delete(int id) {
        persons.removeIf(person -> person.getId() == id);
        writeFile();
    }

    public void restart() {
        persons.forEach(person -> persons.remove(person));
        loadFromFile();
    }

    public Person update(Person person, int personId) {
        Person personToChange = null;
        for (Person person1 : persons) {
            if (person1.getId() == personId) {
                personToChange = person1;
            }
        }
        if (personToChange != null) {
            personToChange.setFirstname(person.getFirstname());
            personToChange.setLastname(person.getLastname());
            writeFile();
            return personToChange;
        }
        return null;
    }

    private void writeFile() {
        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            persons.forEach(person -> {
                try {
                    writer.write(person.writeable());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
