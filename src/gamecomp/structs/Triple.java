package gamecomp.structs;

/**
 * Pair
 */
public class Triple<K,V,Z> {
    private final K first;
    private final V second;
    private final Z third;

    
    /** 
     * @param first
     * @param second
     * @param third
     * @return 
     */
    public Triple(K first, V second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    
    /** 
     * @param newPair
     * @return boolean
     */
    public boolean equals(Triple<K,V,Z> newPair){
        if(this.first.equals(newPair.getK()) && this.second.equals(newPair.getV()) && this.third.equals(newPair.getZ())){
            return true;
        }
        return false;
    }

    
    /** 
     * @return K
     */
    public K getK(){
        return first;
    }

    
    /** 
     * @return V
     */
    public V getV(){
        return second;
    }

    
    /** 
     * @return Z
     */
    public Z getZ(){
        return third;
    }

}