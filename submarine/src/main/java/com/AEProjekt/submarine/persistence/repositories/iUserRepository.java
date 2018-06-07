package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.users.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 07.06.2018.
 */
public interface iUserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
