package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.persistence.entities.PointEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 06.06.2018.
 */
public interface iPointRepository extends CrudRepository<PointEntity, Long> {
}
