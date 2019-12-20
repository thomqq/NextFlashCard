/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tkudas
 */
@Entity
@Table(name = "flashcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FlashCardEntity.findAll", query = "SELECT f FROM FlashCardEntity f"),
    @NamedQuery(name = "FlashCardEntity.findById", query = "SELECT f FROM FlashCardEntity f WHERE f.id = :id"),
    @NamedQuery(name = "FlashCardEntity.findByQuestion", query = "SELECT f FROM FlashCardEntity f WHERE f.question = :question"),
    @NamedQuery(name = "FlashCardEntity.findByAnswer", query = "SELECT f FROM FlashCardEntity f WHERE f.answer = :answer")})
public class FlashCardEntity implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "correct")
    private int correct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incorrect")
    private int incorrect;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "answer")
    private String answer;

    public FlashCardEntity() {
    }

    public FlashCardEntity(Integer id) {
        this.id = id;
    }

    public FlashCardEntity(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        if (!(object instanceof FlashCardEntity)) {
            return false;
        }
        FlashCardEntity other = (FlashCardEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tq.arxsoft.nextflashcard.entity.Flashcard[ id=" + id + " ]";
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
    
}
