package com.akgcloud.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// implements list and override set, add and modify type of method
public class UnmodifiableList<E> implements List<E> {

	private final List<? extends E> list;

	public UnmodifiableList(List<? extends E> l) {
		this.list = l;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add(null);
		list.add("B");
		// Iterator<String> itr = list.iterator();
		// while (itr.hasNext()) {
		// if (itr.next() == null) {
		// itr.remove();
		// }
		// }
		// for (String str : new ArrayList<String>(list)) {
		// if ("A".equals(str)) {
		// list.remove("A");
		// }
		// }

		// System.out.println(list.toString());
		// List<String> unList = Collections.unmodifiableList(list);
		List<String> myUnList = new UnmodifiableList<String>(list);
		System.out.println(myUnList.size());
		for (int i = 0; i < myUnList.size(); i++) {
			System.out.print(myUnList.get(i) + ", ");
		}
		// myUnList.add("Z");
		System.out.println();
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		List<Integer> unIntList = new UnmodifiableList<Integer>(intList);
		for (int i = 0; i < unIntList.size(); i++) {
			System.out.println(unIntList.get(i) + ", ");
		}
		unIntList.add(3);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public E get(int index) {
		return list.get(index);
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
