package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitr on 21.11.2015.
 */
public class GenericStorage<K extends Number, V> {
    private List<K> keys;
    private List<V> values;

    public GenericStorage(){
        setKeys(new ArrayList<K>());
        setValues(new ArrayList<V>());
    }

    public boolean put(K key, V value){
        if(!getKeys().contains(key)) {
            getKeys().add(key);
            getValues().add(value);
            return  true;
        }else{
            return false;
        }
    }

    public boolean delete(K key){
        int index = getKeys().indexOf(key);
        if(index != -1){
            getKeys().remove(index);
            getValues().remove(index);
            return  true;
        }
        return  false;
    }


    public V get(K key){
        if(getKeys().contains(key)) {
           return getValues().get(getKeys().indexOf(key));
        }
        return null;
    }

    public List<V> getAll(){
        return new ArrayList<V>(getValues());
    }

    protected List<K> getKeys() {
        return keys;
    }

    protected void setKeys(List<K> keys) {
        this.keys = keys;
    }

    protected List<V> getValues() {
        return values;
    }

    protected void setValues(List<V> values) {
        this.values = values;
    }
}
