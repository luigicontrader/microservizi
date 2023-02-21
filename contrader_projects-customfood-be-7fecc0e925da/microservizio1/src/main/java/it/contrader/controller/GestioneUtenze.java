package it.contrader.controller;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Slf4j
@RestController
public class GestioneUtenze {


    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public String home() throws IOException, InterruptedException {
        return "<h2>MICROSERVIZIO 1, ID ISTANZA: " + printHostname() + "</h2>";
    }

    //POST React a UserDTO
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) throws Exception{
        return userService.login(loginDTO);
    }

    public static String printHostname() throws IOException, InterruptedException {
        String cmd = "hostname";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        line = buf.readLine();
        return line;
    }


}


