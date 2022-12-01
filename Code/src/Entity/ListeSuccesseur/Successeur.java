package Entity.ListeSuccesseur;

import Entity.Arc;

public class Successeur {
    
    private int name;
    private Successeur suivant;
    private Arc arc;

    // public Successeur(int n){
    //     this.name = n;
    //     this.suivant = null;
    //     this.arc = null;
    // }

    public Successeur(int n, Arc a){
        this.name = n;
        this.suivant = null;
        this.arc = a;
    }
    
    public int getName(){
        return this.name;
    }

    public void setName(int n){
        this.name = n;
    }

    public Successeur getSuivant(){
        return this.suivant;
    }

    public void setSuivant(Successeur s){
        this.suivant = s;
    }

    public Arc getArc(){
        return this.arc;
    }

    public void setArc(Arc a){
        this.arc = a;
    }

    public String toString(){
        String str = "";
        if(this.suivant != null){
            str = "\n  [ " + this.name + " , arc " + this.getArc().toString() + "]" + this.suivant +"\n";
        } else {
            str = "\n  [ " + this.name + " , arc " + this.getArc().toString() + "]";

        }
        
        return str;
    }
}