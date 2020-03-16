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
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByMovie", query = "SELECT p FROM Products p WHERE p.movie = :movie"),
    @NamedQuery(name = "Products.findByRating", query = "SELECT p FROM Products p WHERE p.rating = :rating"),
    @NamedQuery(name = "Products.findByYearcreate", query = "SELECT p FROM Products p WHERE p.yearcreate = :yearcreate"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
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

    public Products() {
    }

    public Products(String movie) {
        this.movie = movie;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movie != null ? movie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.movie == null && other.movie != null) || (this.movie != null && !this.movie.equals(other.movie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Products[ movie=" + movie + " ]";
    }

}
