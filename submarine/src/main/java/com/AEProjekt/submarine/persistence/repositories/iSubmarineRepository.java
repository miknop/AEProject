package com.AEProjekt.submarine.persistence.repositories;

import com.AEProjekt.submarine.figures.Submarine;
import com.AEProjekt.submarine.persistence.entities.SubmarineEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by backes_tor on 06.06.2018.
 */
public interface iSubmarineRepository extends CrudRepository<SubmarineEntity, String> {
}
