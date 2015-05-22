/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renny
 */
@Entity
@Table(name = "monster_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonsterDetails.findAll", query = "SELECT m FROM MonsterDetails m"),
    @NamedQuery(name = "MonsterDetails.findById", query = "SELECT m FROM MonsterDetails m WHERE m.id = :id"),
    @NamedQuery(name = "MonsterDetails.findByName", query = "SELECT m FROM MonsterDetails m WHERE m.name = :name"),
    @NamedQuery(name = "MonsterDetails.findByValue", query = "SELECT m FROM MonsterDetails m WHERE m.value = :value")})
public class MonsterDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "img")
    private byte[] img;
    @Column(name = "value")
    private Integer value;
    @JoinColumn(name = "player_phone", referencedColumnName = "phone")
    @ManyToOne(optional = false)
    private Player playerPhone;

    public MonsterDetails() {
    }

    public MonsterDetails(Integer id) {
        this.id = id;
    }

    public MonsterDetails(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Player getPlayerPhone() {
        return playerPhone;
    }

    public void setPlayerPhone(Player playerPhone) {
        this.playerPhone = playerPhone;
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
        if (!(object instanceof MonsterDetails)) {
            return false;
        }
        MonsterDetails other = (MonsterDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MonsterDetails[ id=" + id + " ]";
    }
    
}
