package model;

import entity.Presentation;
import entity.SignUp;
import java.util.List;


public class SignUpRepository extends Repository{
    private List<SignUp> signUps;
    
    public List<SignUp> findAllByPlanning(Presentation presentation) {
        getEm().getTransaction().begin();

        signUps =  getEm().createQuery("SELECT s FROM " + SignUp.class.getSimpleName() + "  JOIN s.presentation pr WHERE pr.id = :presentation").setParameter("presentation", presentation.getId()).getResultList();
        getEm().getTransaction().commit();
        
        getEm().close();
        
        return signUps;
    }
}
