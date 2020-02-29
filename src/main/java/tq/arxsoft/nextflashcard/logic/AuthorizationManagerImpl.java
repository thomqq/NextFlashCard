/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.logic;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import tq.arxsoft.nextflashcard.entity.UserAuth;

/**
 *
 * @author tkudas
 */

@Component
@Primary
@Transactional
public class AuthorizationManagerImpl implements AuthorizationManager {
    @PersistenceUnit
    EntityManagerFactory emf;

    @Override
    public UserAuth getUserUtAuth(String userName) {
        Query query = emf.createEntityManager().createNamedQuery("UserAuth.findByUsername");
        query.setParameter("username", userName);

        List< UserAuth> user = query.getResultList();
        if (user != null && !user.isEmpty()) {
            return user.get(0);
        }
        return null;
    }
}
