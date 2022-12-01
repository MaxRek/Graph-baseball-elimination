package Entity.ListeSuccesseur;

public class ListeSuccesseur {

    private Successeur premier;

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
            return "vide";
        } else {
            return this.premier.toString();
        }
        // return this.premier.toString();
    }

}
