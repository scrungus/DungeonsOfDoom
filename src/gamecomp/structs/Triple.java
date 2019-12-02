package gamecomp.structs;

/**
 * Pair
 */
public class Triple<K,V,Z> {
    private final K first;
    private final V second;
    private final Z third;

    public Triple(K first, V second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public boolean equals(Triple<K,V,Z> newPair){
        if(this.first.equals(newPair.getK()) && this.second.equals(newPair.getV()) && this.third.equals(newPair.getZ())){
            return true;
        }
        return false;
    }

    public K getK(){
        return first;
    }

    public V getV(){
        return second;
    }

    public Z getZ(){
        return third;
    }

}