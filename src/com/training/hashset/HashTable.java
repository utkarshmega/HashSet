package com.training.hashset;

import java.util.ArrayList;

public class HashTable<K, V> {

	public int bucketSize = 10;
	private ArrayList<MyMapNode<K, V>> bucketArray;
	private int size;

	public HashTable() {
		bucketArray = new ArrayList<>();
		bucketSize = 10;
		size = 0;

		for (int i = 0; i < bucketSize; i++)
			bucketArray.add(null);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// This implements hash function to find index
	// for a key
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % bucketSize;
		return index;
	}

	// to find the value associated with the string
	public V get(K key) {
		int bucketIndex = getBucketIndex(key);
		MyMapNode<K, V> head = bucketArray.get(bucketIndex);

		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}

		return null;
	}

	public void add(K key, V value) {
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		MyMapNode<K, V> head = bucketArray.get(bucketIndex);

		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = bucketArray.get(bucketIndex);
		MyMapNode<K, V> newNode = new MyMapNode<K, V>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);
	}

	public static void main(String[] args) {
		
		String s = "To be or not to be";
		String arr[] = s.split(" ");
		HashTable<String, Integer> hashMap = new HashTable<>();
		for(String str : arr)
		{
			Integer tmp = hashMap.get(str);
			if(tmp == null) {
				hashMap.add(str, 1);
			}
			else
				hashMap.add(str, tmp+1);
		}
		for(String a : arr){
            System.out.println(a + " ---> " + hashMap.get(a));
        }		
		
	}

}
