package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.persistence.entities.ShipEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 06.06.2018.
 */
public interface iShipRepository extends CrudRepository<ShipEntity, String> {
}
