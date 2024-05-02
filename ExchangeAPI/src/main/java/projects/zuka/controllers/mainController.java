package projects.zuka.controllers;

import projects.zuka.connection.Connection;
import projects.zuka.persistence.ExchangeRepository;
import projects.zuka.persistence.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class mainController {


    public static final int PORT = 8081;
    private ExchangeRepository exchangeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<Map<String, String>> information() {

        Map<String, String> inf = new HashMap<>();
        String ip = Connection.getIp();

        inf.put("owner", "João Oliveira");
        inf.put("rates", "http://" + ip + ":" + PORT + "/api/rates");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Host", "http://" + ip + ":" + PORT);

        return new ResponseEntity<>(inf, httpHeaders, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/rates")
    public ResponseEntity<Iterable<Data>> showData() {

        return new ResponseEntity<>(exchangeRepository.findAll(), HttpStatus.OK);
    }

    @Autowired
    public void setExchangeRepository(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }
}
