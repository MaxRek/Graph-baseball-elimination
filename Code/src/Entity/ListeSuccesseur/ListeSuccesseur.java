package Entity.ListeSuccesseur;

public class ListeSuccesseur {

    protected Successeur premier;

    public ListeSuccesseur(){
        this.premier = null;
    }

    public Successeur getSuccesseur(){
        return this.premier;
    }

    public void addSuccesseur(Successeur s){
        if(this.premier == null){
            this.premier = s;
        } else {
            Boolean end = false;
            Successeur r = this.premier;
            while(!end){
                if(r.getName()==s.getName()){
                    end = true;
                }
                if(!end){
                    if (r.getSuivant()!=null){
                        r = r.getSuivant();
                    } else {
                        r.setSuivant(s);
                        end = true;
                    }
                }
            }
        }
    }


    public void updateFlotSuccesseur(int se, int f, int c, Boolean r){
        if(this.premier == null){ // si la liste est vide, on ajoute un sucesseur avec le flot ajouté
            this.premier = new Successeur(se, new Arc(f, c, r));
        } else {
            Boolean end = false;
            Successeur s = this.premier;
            while(!end){
                if(s.getName()==se){
                    end = true;
                    s.getArc().setFlot(f);
                }
                if(!end){
                    if (s.getSuivant()!=null){
                        s = s.getSuivant();
                    } else {
                        s.setSuivant(new Successeur(se,new Arc(f, c, r)));
                        end = true;
                    }
                }
            }
        }
    }


    public void delSuccesseur(int n){
        if(this.premier != null){
            Successeur s = this.premier;
            Successeur d = this.premier;
            Boolean end = false;
            Boolean stop = false;

            while(!end && !stop){
                if(s.getName()==n){
                    stop = true;
                } else if (s.getSuivant()==null) {
                    end = true;
                } else {
                    d = s;
                    s = s.getSuivant();
                }
            }
            
            if(end == true){
                System.out.println("Erreur : Successeur non trouvé");
            } else {
                if(stop){
                    if(s==d){
                        if(s.getSuivant()!=null){
                            this.premier = s.getSuivant();
                        } else {
                            this.premier = null;
                        }
                    } else {
                        if(s.getSuivant()!=null){
                            d.setSuivant(s.getSuivant());
                        } else {
                            d.setSuivant(null);
                        }
                    }
                }
            }
        }    
    }

    public String toString(){
        if(this.premier == null){
            return null;
        } else {
            return this.premier.toString();
        }
        // return this.premier.toString();
    }

}
