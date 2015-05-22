/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renny
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name"),
    @NamedQuery(name = "Player.findByEmail", query = "SELECT p FROM Player p WHERE p.email = :email"),
    @NamedQuery(name = "Player.findByCaloryBurnedTotal", query = "SELECT p FROM Player p WHERE p.caloryBurnedTotal = :caloryBurnedTotal"),
    @NamedQuery(name = "Player.findByStepsTaken", query = "SELECT p FROM Player p WHERE p.stepsTaken = :stepsTaken"),
    @NamedQuery(name = "Player.findByPassoword", query = "SELECT p FROM Player p WHERE p.passoword = :passoword"),
    @NamedQuery(name = "Player.findByPhone", query = "SELECT p FROM Player p WHERE p.phone = :phone"),
    @NamedQuery(name = "Player.findByWeight", query = "SELECT p FROM Player p WHERE p.weight = :weight"),
    @NamedQuery(name = "Player.findByExp", query = "SELECT p FROM Player p WHERE p.exp = :exp"),
    @NamedQuery(name = "Player.findByMonsterMoney", query = "SELECT p FROM Player p WHERE p.monsterMoney = :monsterMoney"),
    @NamedQuery(name = "Player.findByHuntId", query = "SELECT p FROM Player p WHERE p.huntId = :huntId")})
public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calory_burned_total")
    private int caloryBurnedTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "steps_taken")
    private int stepsTaken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "passoword")
    private String passoword;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "exp")
    private Integer exp;
    @Column(name = "monster_money")
    private Integer monsterMoney;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerPhone")
    private Collection<MonsterDetails> monsterDetailsCollection;

    public Player() {
    }

    public Player(Integer phone) {
        this.phone = phone;
    }

    public Player(Integer phone, String name, String email, int caloryBurnedTotal, int stepsTaken, String passoword, int huntId) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.caloryBurnedTotal = caloryBurnedTotal;
        this.stepsTaken = stepsTaken;
        this.passoword = passoword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCaloryBurnedTotal() {
        return caloryBurnedTotal;
    }

    public void setCaloryBurnedTotal(int caloryBurnedTotal) {
        this.caloryBurnedTotal = caloryBurnedTotal;
    }

    public int getStepsTaken() {
        return stepsTaken;
    }

    public void setStepsTaken(int stepsTaken) {
        this.stepsTaken = stepsTaken;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getMonsterMoney() {
        return monsterMoney;
    }

    public void setMonsterMoney(Integer monsterMoney) {
        this.monsterMoney = monsterMoney;
    }



    @XmlTransient
    public Collection<MonsterDetails> getMonsterDetailsCollection() {
        return monsterDetailsCollection;
    }

    public void setMonsterDetailsCollection(Collection<MonsterDetails> monsterDetailsCollection) {
        this.monsterDetailsCollection = monsterDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phone != null ? phone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.phone == null && other.phone != null) || (this.phone != null && !this.phone.equals(other.phone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Player[ phone=" + phone + " ]";
    }
    
}
