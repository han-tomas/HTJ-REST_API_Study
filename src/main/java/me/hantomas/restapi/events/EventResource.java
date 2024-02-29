package me.hantomas.restapi.events;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class EventResource extends Resource<Event> {

    public EventResource(Event event, Link... links) {
        super(event, links);
        //add(new Link("http://localhost:8080/api/events/"+ event.getId())); // TypeSafe하지 않다.
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}
