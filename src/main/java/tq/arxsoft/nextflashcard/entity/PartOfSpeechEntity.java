/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author tkudas
 */
@Entity
@Table(name = "part_of_speech")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartOfSpeechEntity.findAll", query = "SELECT p FROM PartOfSpeechEntity p"),
    @NamedQuery(name = "PartOfSpeechEntity.findById", query = "SELECT p FROM PartOfSpeechEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PartOfSpeechEntity.findByName", query = "SELECT p FROM PartOfSpeechEntity p WHERE p.name = :name")})
public class PartOfSpeechEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "partOfSpeechId")
    private Collection<FlashCardEntity> flashCardEntityCollection;

    public PartOfSpeechEntity() {
    }

    public PartOfSpeechEntity(Integer id) {
        this.id = id;
    }

    public PartOfSpeechEntity(Integer id, String name) {
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

    @XmlTransient
    public Collection<FlashCardEntity> getFlashCardEntityCollection() {
        return flashCardEntityCollection;
    }

    public void setFlashCardEntityCollection(Collection<FlashCardEntity> flashCardEntityCollection) {
        this.flashCardEntityCollection = flashCardEntityCollection;
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
        if (!(object instanceof PartOfSpeechEntity)) {
            return false;
        }
        PartOfSpeechEntity other = (PartOfSpeechEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tq.arxsoft.nextflashcard.entity.PartOfSpeechEntity[ id=" + id + " ]";
    }
    
}
