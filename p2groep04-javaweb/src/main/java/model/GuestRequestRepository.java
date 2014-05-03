package model;

import entity.Presentation;
import entity.GuestRequest;
import java.util.List;


public class GuestRequestRepository extends Repository{
    private List<GuestRequest> signUps;
    
    public List<GuestRequest> findAllByPresentation(Presentation presentation) {
        getEm().getTransaction().begin();

        signUps =  getEm().createQuery("SELECT s FROM " + GuestRequest.class.getSimpleName() + "  JOIN s.presentation pr WHERE pr.id = :presentation").setParameter("presentation", presentation.getId()).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return signUps;
    }
}
