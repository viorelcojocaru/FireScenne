/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


/**
 *
 * @author viorel.cojocaru
 */
public class Info {

    private int id;
    private String tags;
    private String timpIn;
    private String timpOut;
    private String comments;
    private String anotimp;
    private String fisierNume;
    
    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimpIn() {
        return timpIn;
    }

    public void setTimpIn(String timpIn) {
        this.timpIn = timpIn;
    }

    public String getTimpOut() {
        return timpOut;
    }

    public void setTimpOut(String timpOut) {
        this.timpOut = timpOut;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFisierNume() {
        return fisierNume;
    }

    public void setFisierNume(String fisierNume) {
        this.fisierNume = fisierNume;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAnotimp() {
        return anotimp;
    }

    public void setAnotimp(String anotimp) {
        this.anotimp = anotimp;
    }

    public Info(int id, String tags, String timpIn, String timpOut, String comments, String anotimp, String fisierNume) {
        this.id = id;
        this.tags = tags;
        this.timpIn = timpIn;
        this.timpOut = timpOut;
        this.comments = comments;
        this.anotimp = anotimp;
        this.fisierNume = fisierNume;
    }

    public Info(String tags, String timpIn, String timpOut, String comments, String anotimp, String fisierNume) {
        this.tags = tags;
        this.timpIn = timpIn;
        this.timpOut = timpOut;
        this.comments = comments;
        this.anotimp = anotimp;
        this.fisierNume = fisierNume;
    }

    @Override
    public String toString() {
        return "Info{" + "id=" + id + ", tags=" + tags + ", timpIn=" + timpIn + ", timpOut=" + timpOut + ", comments=" + comments + ", anotimp=" + anotimp + ", fisierNume=" + fisierNume + '}'+"\n";
    }

}
