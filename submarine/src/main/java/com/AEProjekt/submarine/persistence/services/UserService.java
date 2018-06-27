package com.AEProjekt.submarine.persistence.services;

import com.AEProjekt.submarine.persistence.entities.UserEntity;
import com.AEProjekt.submarine.persistence.exceptions.EntityAlreadyExistsException;
import com.AEProjekt.submarine.persistence.exceptions.EntityNotFoundException;
import com.AEProjekt.submarine.persistence.mapper.UserMapper;
import com.AEProjekt.submarine.persistence.repositories.iUserRepository;
import com.AEProjekt.submarine.users.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
/**
 * Created by backes_tor on 19.06.2018.
 *
 * User Service. Handles all CRUD Operations. Acts in between Software logic and database logic as abstraction layer.
 */
public class UserService {

    private iUserRepository userRepository;

    @Autowired
    public UserService(iUserRepository aUserRepository) {
        userRepository = aUserRepository;
    }

    /**
     * creates a new User in Database by making use of the CRUD repository.
     * @param user
     */
    public void createUserEntity(User user) {
        log.debug("At User Service (CREATE)");
        if (userRepository.findByUsername(user.getUsername()) == null) {
            UserEntity userEntity = UserMapper.fromObjectToEntity(user);
            log.debug("User Entity (CREATED): {}", userEntity);
            userRepository.save(userEntity);
        } else {
            throw new EntityAlreadyExistsException();
        }
    }

    /**
     * updates a new User in Database by making use of the CRUD repository.
     * @param user
     */
    public void updateUserEntity(User user) {
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        if (userEntity != null) {
            userEntity.setUsername(user.getUsername());
            userEntity.setClassNumber(user.getClassNumber());
            userEntity.setLevel(UserMapper.mapLevelInt(user));
            userEntity.setBeatList(user.getLevel().getLevelbeatcounter().getBeatList());
        } else {
            throw new EntityNotFoundException();
        }
    }

    /**
     *
     * @param name
     * @return User
     * returns one User from Database who was selected by name
     */
    public User getUser(String name) {
        UserEntity entity = userRepository.findByUsername(name);
        if (entity != null) {
            return UserMapper.fromEntityToObject(entity);
        } else {
            throw new EntityNotFoundException();
        }

    }

    /**
     *
     * @return List of Users
     * returns a List of all Users that currently are persisted in the Database.
     */
    public List<User> getUsers() {
        Iterable<UserEntity> iterable = userRepository.findAll();
        List<UserEntity> list = (List) iterable;
        if (!list.isEmpty()) {
            return UserMapper.fromEntitiesToObjects(list);
        }
        throw new EntityNotFoundException();
    }

    /**
     *
     * @param classNumber
     * @return List of Users that are part of a certain Class.
     */
    public List<User> getUsersByClassNumber(String classNumber) {
        Iterable<UserEntity> iterable = userRepository.findByClassNumber(classNumber);
        List<UserEntity> list = (List) iterable;
        if (!list.isEmpty()) {
            return UserMapper.fromEntitiesToObjects(list);
        }
        throw new EntityNotFoundException();
    }

    /**
     * enables removing one user from the Database.
     * @param name
     */
    public void deleteUserEntity(String name) {
        UserEntity userEntity = userRepository.findByUsername(name);
        if (userEntity != null) {
            userRepository.delete(userEntity);
            log.debug("DELETION SUCCESSFUL");
        } else {
            throw new EntityNotFoundException();
        }
    }

}
