package model.repositories;

import entity.GuestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface GuestRequestRepository extends JpaRepository<GuestRequest, Long>{
    @Query("select g from GuestRequest g where username = ?1 and presentation.id = ?2")
    GuestRequest findbyUsernameAndPresentationId(String username, int id);
}
