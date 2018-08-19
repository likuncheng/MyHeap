package com.imooc.heap;

import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {

	private ArrayList<E> list = new ArrayList<>();
	
	public Heap(){
		
	}
	
	public Heap(E[] e){
		for(int i = 0;i < e.length;i++){
			add(e[i]);
		}
	}

	public void add(E e) {
		list.add(e);
		int currentIndex = list.size()-1;
		
		while(currentIndex > 0) {
			int parentIndex = (currentIndex-1)/2;
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
				E tmp = list.get(currentIndex);
				list.set(currentIndex,list.get(parentIndex));
				list.set(parentIndex, tmp);
			}
			else
				break;
			currentIndex = parentIndex;
		}
	}
	
	public E remove(){
		
		if(list.size() == 0)
			return null;
		E removeObject = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int currentIndex  = 0;
		
		
		while(currentIndex < list.size()){
			int leftIndex = currentIndex * 2 + 1;
			int rightIndex = currentIndex * 2 + 2;
			if(leftIndex >= list.size()){
				break;
			}
			E max = list.get(leftIndex);
			int maxIndex = leftIndex;
			if(rightIndex < list.size()){
				if(list.get(rightIndex).compareTo(max) > 0){
					max = list.get(rightIndex);
					maxIndex = rightIndex;
				}
			}
			if(list.get(currentIndex).compareTo(max) < 0){
				E tmp = list.get(currentIndex);
				list.set(currentIndex, max);
				list.set(maxIndex, tmp);
				currentIndex = maxIndex;
			}
			else
				break;
		}
		return removeObject;
	}
	
	public int size(){
		return list.size();
	}

	public ArrayList<E> getList() {
		return list;
	}
	
}
