/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.repositories;

import entity.Planning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maxim
 */
public interface PlanningRepository extends JpaRepository<Planning, Long>{
    
    @Transactional
    @Query("select pl from Planning pl where pl.id = ?1")
    Planning findOneById(Long id);
}
