package model;

import entity.GuestRequest;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRequestRepository extends JpaRepository<GuestRequest, Long>{
    
}
