package com.MdgCorp.RestWebService.controller;

import com.MdgCorp.RestWebService.entity.Person;
import com.MdgCorp.RestWebService.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class PersonListController {

    private final PersonService personService;

    public PersonListController(PersonService personService) {
        this.personService = personService;
    }

    // Get List of cars
    @GetMapping("/view/persons")
    @ResponseStatus(HttpStatus.OK)
    public String ViewListOfPersons() {

        StringBuilder html = new StringBuilder();

        html.append("<html>")
                .append("<a href='/'><-- Back</a>")
                .append("<h1 style=\"text-align: center;\">List Of Persons</h1>")
                .append("<body>")
                .append("<p><ul>");

        for (Person person : personService.getPersons()) {
            html.append("<li>")
                    .append("<a href='/view/persons/")
                    .append(person.getName())
                    .append("'>")
                    .append(person.getName())
                    .append("</a>")
                    .append("</li>");
        }

        html.append("</ul></p>")
                .append("</body>")
                .append("</html>");

        return html.toString();
    }


    // Get a car by plateNumber
    @GetMapping("/view/persons/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String Print(@PathVariable("name") String name) throws Exception {

        Person P = new Person();

        for (Person person : personService.getPersons()) {
            if (Objects.equals(person.getName(), name)) {
                P = person;
            }
        }

        return "<html>" +
                "<body>" +
                "<a href='/view/persons'><-- Back</a>" +
                "<p>" + P.getName() + "</p>" +
                "</body>" +
                "</html>";
    }

}
