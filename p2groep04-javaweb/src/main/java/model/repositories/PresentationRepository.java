/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.repositories;

import entity.Planning;
import entity.Presentation;
import entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Maxim
 */
public interface PresentationRepository extends JpaRepository<Presentation, Long>
{
    @Query("select p from Presentation p left join fetch p.attendees a where p.planning = ?1")
    List<Presentation> findByPlanning(Planning planning);
}
