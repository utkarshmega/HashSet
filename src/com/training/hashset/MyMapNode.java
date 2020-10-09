package com.training.hashset;

public class MyMapNode<K, V> {
	
	K key;
	V value;
	MyMapNode<K, V> next;
	
	public MyMapNode(K key, V value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}
	

}
