package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.persistence.entities.PlaneEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 06.06.2018.
 */
public interface iPlaneRepository extends CrudRepository<PlaneEntity, String> {
}
