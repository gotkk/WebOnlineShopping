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
import javax.persistence.Query;

/**
 *
 * @author KRuser
 */
public class ProductsTable {

    public static List<Products> findAllProducts() {
        EntityManagerFactory prf = Persistence.createEntityManagerFactory("WebOnlineShoppingPU");
        EntityManager pr = prf.createEntityManager();
        List<Products> proList = (List<Products>) pr.createNamedQuery("Products.findAll").getResultList();
        pr.close();
        return proList;
    }

    public static List<Products> findProductsByName(String name) {
        EntityManagerFactory prf = Persistence.createEntityManagerFactory("WebOnlineShoppingPU");
        EntityManager pr = prf.createEntityManager();
        Query query = pr.createNamedQuery("Products.findByMovie");
        query.setParameter("movie", name);
        List<Products> proList = (List<Products>) query.getResultList();
        pr.close();
        return proList;
    }

}
