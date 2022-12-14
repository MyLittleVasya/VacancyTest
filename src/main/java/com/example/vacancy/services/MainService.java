package com.example.vacancy.services;

import com.example.vacancy.dto.PersonDTO;
import com.example.vacancy.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class MainService {
    @Autowired
    private PersonRepo personRepo;
    public PersonDTO getPersonFromDb(long id) throws HttpStatusCodeException {
        var person = personRepo.findById(id);
        if (person != null) {
            return new PersonDTO(
                    person.getFirstName(),
                    person.getLastName(),
                    person.getBirthday());
        }
        return null;
    }
}
