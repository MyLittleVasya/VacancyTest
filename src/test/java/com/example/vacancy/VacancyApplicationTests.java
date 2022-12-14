package com.example.vacancy;

import com.example.vacancy.controllers.MainController;
import com.example.vacancy.repositories.PersonRepo;
import com.example.vacancy.services.MainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class VacancyApplicationTests {

    private final static String URL = "jdbc:h2:mem:test";
    private final static String USER = "sa";
    private final static String PASSWORD = "";
    @Autowired
    private MainController mainController;

    @Autowired
    private MainService mainService;

    @Autowired
    private PersonRepo repo;


    @Test
    public void Test_db_connection() throws Exception {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        assertThat(connection).isNotNull();
    }
    @Test
    public void Verify_controller_is_not_null() throws Exception {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void Verify_service_is_not_null() throws Exception {
        assertThat(mainService).isNotNull();
    }

    @Test
    public void Verify_repo_is_not_null() throws Exception {
        assertThat(repo).isNotNull();
    }

    @Test
    public void Verify_request_invalid_argument_throws_exception() throws Exception {
        HttpServerErrorException e1 = assertThrows(HttpServerErrorException.class, () -> {
            mainController.getPerson(0);
        });
        HttpServerErrorException e2 = assertThrows(HttpServerErrorException.class, () -> {
            mainController.getPerson('f');
        });
        HttpServerErrorException e3 = assertThrows(HttpServerErrorException.class, () -> {
            mainController.getPerson(-1);
        });
    }

    @Test
    public void Verify_db_entity_not_found_exception() throws Exception {
        var lastId = repo.findTopByOrderByIdDesc().getId();
        HttpServerErrorException e = assertThrows(HttpServerErrorException.class, () -> {
            mainController.getPerson(lastId+1);
        });
    }
}
