package gamecomp.structs;

/**
 * Pair
 */
public class Pair<K,V> {
    private final K key;
    private final V value;

    
    /** 
     * @param key
     * @param value
     * @return 
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    
    /** 
     * @param newPair
     * @return boolean
     */
    public boolean equals(Pair<K,V> newPair){
        if(this.key.equals(newPair.getK()) && this.value.equals(newPair.getV())){
            return true;
        }
        return false;
    }

    
    /** 
     * @return K
     */
    public K getK(){
        return key;
    }

    
    /** 
     * @return V
     */
    public V getV(){
        return value;
    }

}