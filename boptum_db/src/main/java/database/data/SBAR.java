package database.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SBAR {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String situation;
    private String background;
    private String assessment;
    private String recommendation;
    private String date;
    
    private String provider;

    @ManyToOne
    private Patient patient;

    public SBAR() {}

    public SBAR(String situation, String background, String assessment, String recommendation, String date, String provider) {
        setSituation(situation);
        setBackground(background);
        setAssessment(assessment);
        setRecommendation(recommendation);
        setDate(date);
        setProvider(provider);
    }

    public void setSituation(String s) {
        this.situation = s;
    }

    public void setBackground(String s) {
        this.background = s;
    }

    public void setAssessment(String s) {
        this.assessment = s;
    }

    public void setRecommendation(String s) {
        this.recommendation = s;
    }

    public void setDate(String s) {
        this.date = s;
    }

    public void setProvider(String s) {
        this.provider = s;
    }

    public String getSituation() {
        return this.situation;
    }

    public String getBackground() {
        return this.background;
    }

    public String getAssessment() {
        return this.assessment;
    }

    public String getRecommendation() {
        return this.recommendation;
    }

    public String getDate() {
        return this.date;
    }

    public String getProvider() {
        return this.provider;
    }
}