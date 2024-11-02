package org.example.projektiweek3tehtava;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.projektiweek3tehtava.view.LanguageGenerator;

import org.example.projektiweek3tehtava.entity.EmployeeEn;

import java.util.List;

public class Controller {
    LanguageGenerator languageGenerator = new LanguageGenerator();


    public void persist(EmployeeEn employeeEn) {
        EntityManager em = MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(employeeEn);
        em.getTransaction().commit();
    }
}