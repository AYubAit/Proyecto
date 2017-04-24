/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author alumne
 */
public class ALumne implements java.io.Serializable {

    public ALumne(int totm, boolean estat) {
        this.totm = totm;
        this.estat = estat;
    }

    private String nom = null;
    private String nomCicle = null;
    private int mp ;

    @Override
    public String toString() {
        return  " Nom del Alumne =" + nom + ", Nom de Cicle=" + nomCicle ;
    }
    private int ms ;
    private double nota1 ;
    private double nota2 ;
    private int totm;

    private boolean omplit = false;
    private boolean estat;

    ALumne() {
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomCicle() {
        return nomCicle;
    }

    public void setNomCicle(String nomCicle) {
        this.nomCicle = nomCicle;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public int getTotm() {
        return totm;
    }

    public void setTotm(int totm) {
        this.totm = totm;
    }

    public boolean isOmplit() {
        return omplit;
    }

    public void setOmplit(boolean omplit) {
        this.omplit = omplit;
    }

    public boolean isEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

}
