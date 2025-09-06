package Hashing;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;


public class ImplementingHashMap {

    static class HashMap<K , V> {

        LinkedList<Node>[] bucket ;
        int n;       


        class Node{
            K key;
            V value;
            Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }
        
        @SuppressWarnings("unchecked")
        HashMap(){
            this.bucket = new LinkedList[4] ;
            this.n = 0;
            
            for(int i = 0 ; i < bucket.length ; i++){
                bucket[i] = new LinkedList<>();
            }
            
        }
        
        int hash(K key){
            return Math.abs(key.hashCode()) % bucket.length ;
        }
        int searchInLL(K key , int bi){
            int i = 0;
            for(Node pair : bucket[bi]){                
                if(pair.key.equals(key)){
                    return i;
                }
                i++;
            }
            return -1;
        }
        
        @SuppressWarnings("unchecked")
        void rehashing(){
            int N = bucket.length ;
            LinkedList<Node>[] oldBucket = bucket ;

            bucket = new LinkedList[N*2] ;

            for(int i = 0 ; i < N*2 ; i++){
                bucket[i] = new LinkedList<>();
            }
            n = 0;
            for(int i = 0 ; i < oldBucket.length ; i++){
                for(Node pair : oldBucket[i]){
                    put(pair.key, pair.value);
                }
            }
        }
       
        
        Set<K> keySet(){
            Set<K> keys = new HashSet<>();
            for(int i = 0 ; i < bucket.length ; i++){
                for(Node pair : bucket[i]){
                    keys.add(pair.key);
                }
            }

            return keys;
        }

        void put(K key , V value){
            int bi = hash(key);
            int li = searchInLL(key , bi);

            if(li != -1){
                bucket[bi].get(li).value = value;                
                return;
            } else {
                bucket[bi].add(new Node(key , value)) ;
                n++;
                double lambda = (double)n/bucket.length;
                if(lambda > 2){
                    rehashing();
                }
                return ;
            }
        }
       
        V remove(K key){
            int bi = hash(key);
            int li = searchInLL(key , bi);

            if(li != -1){
                n--;
                return bucket[bi].remove(li).value ;                
            } 
            return null ;
        }
       
        V get(K key){
            int bi = hash(key);
            int li = searchInLL(key , bi);

            if(li != -1){
                return bucket[bi].get(li).value ;                
            } 
            return null ;
        }

        int size() {
            return n;
        }
        
        boolean containsKey(K key){
            return get(key) != null;
        }

        boolean isEmpty(){
            return n == 0 ;
        }
        
    }
        public static void main(String args[]){
            HashMap<String , Integer> map = new HashMap<>();

            map.put("apple", 100);
            map.put("banana", 200);
            map.put("orange", 300);

            // Print values
            System.out.println("apple -> " + map.get("apple"));   // 100
            System.out.println("banana -> " + map.get("banana")); // 200
            System.out.println("orange -> " + map.get("orange")); // 300

            // Check containsKey
            System.out.println("Contains 'banana'? " + map.containsKey("banana")); // true
            System.out.println("Contains 'mango'? " + map.containsKey("mango"));   // false

            // Remove a key
            System.out.println("Removing 'banana' -> " + map.remove("banana"));
            System.out.println("Contains 'banana'? " + map.containsKey("banana")); // false

            // Size & emptiness
            System.out.println("Map size → " + map.size()); // 2
            System.out.println("Is empty? " + map.isEmpty()); // false

            // Iterate all keys
            System.out.println("Keys -> " + map.keySet()); // [apple, orange]
        }
        
}
