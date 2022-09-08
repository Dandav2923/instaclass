package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.feign.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.general.PasswordNotValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.services.InstituteService;
import com.clan.instaclass.instituteService.services.impls.InstituteServiceImpl;
import com.clan.instaclass.instituteService.services.impls.MyUserDetailService;
import com.clan.instaclass.instituteService.utility.JWTUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/institutes")
public class InstituteController {
    private final InstituteService instituteService;

    private final JWTUtility jwtUtility;

    private AuthenticationManager authenticationManager;

    private MyUserDetailService myUserDetailService;


    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateInstituteResponse> createInstitute(@RequestBody CreateInstituteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.create(request));
        }
        catch (AlreadyExistingIstituteException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (DataNonValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/loginInstitute",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<LoginInstituteResponse> loginInstitute(@RequestBody LoginInstituteRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

             final UserDetails userDetails = myUserDetailService.loadUserByUsername(request.getUsername());

            final String token = jwtUtility.generateToken(userDetails);

            LoginInstituteResponse response = new LoginInstituteResponse();

            response.setUsername(request.getUsername());
            response.setToken(token);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        catch (BadCredentialsException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @RequestMapping(
            path = "/{idInstitute}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetInstituteResponse> getInstituteById(@PathVariable("idInstitute") Integer instituteId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.get(instituteId));
        }
        catch (InstituteNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/username/{usernameInstitute}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetInstituteResponse> getUsernameInstitute(@PathVariable("usernameInstitute") String instituteUsername) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.getUsername(instituteUsername));
        }
        catch (InstituteNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/updateInstitute",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutInstituteResponse> updateInstitute(@RequestBody PutInstituteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.put(request));
        }
        catch (InstituteNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (DataNonValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @RequestMapping(
            path = "/delete/{idInstitute}",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> delete(@PathVariable("idInstitute") Integer idInstitute) {
        try {
            instituteService.delete(idInstitute);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch (DataNonValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
            path = "/getAllInstitute",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetAllInstituteResponse>> get() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.getAll());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }


}
