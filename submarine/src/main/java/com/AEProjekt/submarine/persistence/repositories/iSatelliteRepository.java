package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.persistence.entities.SatelliteEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 06.06.2018.
 */
public interface iSatelliteRepository extends CrudRepository<SatelliteEntity, Long> {
}
