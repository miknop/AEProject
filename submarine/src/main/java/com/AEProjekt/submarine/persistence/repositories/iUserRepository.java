package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 07.06.2018.
 *
 * User Repository. Enables CRUD operations and one additional functionality to search the User by name in Database.
 */
public interface iUserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * @param username
     * @returns user with this username from Database
     */
    UserEntity findByUsername(String username);
}
