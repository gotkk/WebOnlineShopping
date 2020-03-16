/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author KRuser
 */
@Entity
@Table(name = "SHOPPINGCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findById", query = "SELECT s FROM Shoppingcart s WHERE s.id = :id"),
    @NamedQuery(name = "Shoppingcart.findByCartid", query = "SELECT s FROM Shoppingcart s WHERE s.cartid = :cartid"),
    @NamedQuery(name = "Shoppingcart.findByMovie", query = "SELECT s FROM Shoppingcart s WHERE s.movie = :movie"),
    @NamedQuery(name = "Shoppingcart.findByRating", query = "SELECT s FROM Shoppingcart s WHERE s.rating = :rating"),
    @NamedQuery(name = "Shoppingcart.findByYearcreate", query = "SELECT s FROM Shoppingcart s WHERE s.yearcreate = :yearcreate"),
    @NamedQuery(name = "Shoppingcart.findByPrice", query = "SELECT s FROM Shoppingcart s WHERE s.price = :price"),
    @NamedQuery(name = "Shoppingcart.findByQuantity", query = "SELECT s FROM Shoppingcart s WHERE s.quantity = :quantity")})
public class Shoppingcart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CARTID")
    private Integer cartid;
    @Size(max = 50)
    @Column(name = "MOVIE")
    private String movie;
    @Size(max = 20)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 4)
    @Column(name = "YEARCREATE")
    private String yearcreate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity = 0;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYearcreate() {
        return yearcreate;
    }

    public void setYearcreate(String yearcreate) {
        this.yearcreate = yearcreate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart[ id=" + id + " ]";
    }
    
}
