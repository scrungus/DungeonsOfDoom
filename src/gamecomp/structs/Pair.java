package gamecomp.structs;

/**
 * Pair
 */
public class Pair<K,V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public boolean equals(Pair<K,V> newPair){
        if(this.key.equals(newPair.getK()) && this.value.equals(newPair.getV())){
            return true;
        }
        return false;
    }

    public K getK(){
        return key;
    }

    public V getV(){
        return value;
    }
}