package me.hantomas.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {
    public void validate(EventDto eventDto, Errors errors){
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() > 0){
            //errors.rejectValue("basePrice","wrongValue","BasePrice is wrong");
            //errors.rejectValue("maxPrice","wrongValue","MaxPrice is wrong");
            errors.reject("wrongPrices", "Value of prices are wrong");
        }


        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();

        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime","wrongValue","endEventDateTime is wrong");
        }
    }
}
