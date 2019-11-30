package gamecomp.structs;

/**
 * Pair
 */
public class Pair<F,S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    
    public boolean equals(Pair<F,S> newPair){
        if(this.first.equals(newPair.getF()) && this.second.equals(newPair.getS())){
            return true;
        }
        return false;
    }

    public F getF(){
        return first;
    }

    public S getS(){
        return second;
    }
}