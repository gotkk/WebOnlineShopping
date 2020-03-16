/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KRuser
 */
public class ShoppingcartTable {

    public static List<Shoppingcart> findAllShoppingcart() {
        EntityManagerFactory shf = Persistence.createEntityManagerFactory("WebOnlineShoppingPU");
        EntityManager sh = shf.createEntityManager();
        List<Shoppingcart> shopList = (List<Shoppingcart>) sh.createNamedQuery("Shoppingcart.findAll").getResultList();
        sh.close();
        return shopList;
    }

    public static int insertShoppingcart(Shoppingcart shp) {
        EntityManagerFactory shf = Persistence.createEntityManagerFactory("WebOnlineShoppingPU");
        EntityManager sh = shf.createEntityManager();
        Shoppingcart target = sh.find(Shoppingcart.class, shp.getId());
        if (target != null) {
            return 0;
        }
        sh.getTransaction().begin();
        try {
            sh.persist(shp);
            sh.getTransaction().commit();
        } catch (Exception e) {
            sh.getTransaction().rollback();
            return 0;
        } finally {
            sh.close();
        }
        return 1;
    }

}
