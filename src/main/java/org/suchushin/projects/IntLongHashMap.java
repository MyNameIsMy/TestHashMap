package org.suchushin.projects;

import java.util.NoSuchElementException;

import static java.lang.Math.abs;

public class IntLongHashMap {
    private Entry[] entries;
    private int size;

    IntLongHashMap(){
        entries = new Entry[16];
    }

    void put(int k, long v){
        int index = appropriateIndex(k);
        save(index, new Entry(k, v));
    }

    long get(int k){
        int index = appropriateIndex(k);
        if (entries[index] == null || entries[index].key != k)
            throw new NoSuchElementException();
        return entries[index].value;
    }

    int size(){
        return size;
    }

    //That method is used by resize method and is analog of put(int, long), but is needed for adding already existing entry.
    private void put(Entry entry){
        if (entry != null) {
            int index = appropriateIndex(entry.key);
            save(index, entry);
        }
    }

    //That method increase entries array size by multiplication current length on 1.5 when load factor more than 0.75.
    private void resize(){
        if (((float) size / entries.length) > 0.75f){
            Entry[] tempEntries = entries;
            entries = new Entry[(int) (entries.length * 1.5)];
            size = 0;

            for (Entry e : tempEntries){
                put(e);
            }
        }
    }

    //That method save new entry at given index, also it check resize necessity and increment size variable.
    private void save(int index, Entry entry){
        if (entries[index] != null){
            if (entries[index].key != entry.key)
                shift(index);
            if (entries[index].key == entry.key)
                size--;
        }
        entries[index] = entry;
        size++;
        resize();
    }

    //That method shift every right element rightward on one cell until empty cell is found.
    private void shift(int index){
        Entry entry = entries[index];

        while (entries[getNextIndex(index)] != null) {
            Entry nextEntry = entries[getNextIndex(index)];
            entries[getNextIndex(index)] = entry;
            entry = nextEntry;
            index = getNextIndex(index);
        }

        entries[getNextIndex(index)] = entry;
    }

    //That method return next cell index and return 0 if index is number of last cell.
    private int getNextIndex(int index){
        return (index + 1) % entries.length;
    }

    //That method look for index for given key.
    private int index(int k){
        return abs(k % entries.length);
    }

    //That method realise logic of open addressing.
    private int appropriateIndex(int k){
        int index = index(k);

        while (entries[index] != null){
            if (k == entries[index].key){
                return index;
            }
            if (index(k) < index(entries[index].key)){
                break;
            }
            index = getNextIndex(index);
        }

        return index;
    }

    private static class Entry{
        int key;
        long value;

        Entry(int key, long value) {
            this.key = key;
            this.value = value;
        }
    }
}
