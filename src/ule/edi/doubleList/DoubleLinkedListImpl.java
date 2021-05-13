package ule.edi.doubleList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.list.DoubleLinkedListImpl.Node;

public class DoubleLinkedListImpl<T> implements DoubleLinkedList<T> {
	/**
	 * Nodo doblemente enlazado.
	 * 
	 * Como es estÃ¡tica, no tiene en Ã¡mbito el parÃ¡metro 'T' de la
	 * clase que la contiene. El parÃ¡metro 'D' serÃ¡ sustituÃ­do por
	 * un tipo particular cuando se use el nodo, por ejemplo:
	 * 
	 * 		DoubleNode<T> cab;
	 * 
	 * en la lista.
	 *
	 * @param <D>
	 */
	static class DoubleNode<D> {

		DoubleNode(D element) {
			this.content = element;
			this.previous = null;
			this.next = null;
		}
		
		//	dato a almacenar en el nodo
		D content;
		
		DoubleNode<D> previous;
		
		DoubleNode<D> next;
	}

	/**
	 * Apunta al nodo cabecera; siempre habrÃ¡ un nodo vacÃ­o (sin elemento) que actua de cabecera
	 *  OJO!!! ESTE NODO CABECERA DEBERÃ� CREARSE EN CADA CONSTRUCTOR DE LA LISTA
	 */
	private DoubleNode<T> cab;
	
	
	
	//////////////////////
	/////  CONSTRUCTORES
	//////////////////////
	
	
	/**
	 * Construye una lista vacÃ­a.
	 */
	public DoubleLinkedListImpl() {
		cab.content=null;
		cab.next=cab;
		cab.previous=cab;
		//TODO
		// DeberÃ¡ crear el nodo cabecera vacÃ­o
	
	}
	
	/**
	 * Construye una lista con los elementos dados.
	 * 
	 * Java crearÃ¡ un array 'elements' con los dados en la
	 * llamada al constructor; por ejemplo:
	 * 
	 * 	x = new DoubleLinkedList<String>("A", "B", "C");
	 * 
	 * ejecuta este mÃ©todo con un array [A, B, C] en 
	 * 'elements'.
	 * 
	 * @param elements
	 */
	public DoubleLinkedListImpl(T ... elements) {
		for(T elem : elements) {
        	this.addLast(elem);
        }
	
	}
	
	/**
	 * Construye una lista a partir de otra.
	 * 
	 * Las listas tienen nodos independientes, con los mismos
	 * contenidos.
	 */
	public DoubleLinkedListImpl(DoubleLinkedList<T> other) {
		DoubleNode<T> aux = other.cab;
		while (aux != other.cab) {
			
			addLast(aux.content);
			aux = aux.next;
		}
	
		//TODO
	}
	

	
	//////////////////////
	/////  ITERADORES
	//////////////////////
	
	private class ForwardIterator implements Iterator<T> {

		private DoubleNode<T> at ;
		
		@Override
		public boolean hasNext() {
			return false;
			// TODO Auto-generated method stub
			
		}

		@Override
		public T next() {
			return null;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};
	
	
	private class reverseIterator implements Iterator<T> {

		private DoubleNode<T> at ;
		
		@Override
		public boolean hasNext() {
			return false;
			// TODO Auto-generated method stub
			
		}

		@Override
		public T next() {
			return null;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};

		private class OddAndEvenIterator implements Iterator<T> {

		// Definir los atributos necesarios para implementar el iterador
		
		public OddAndEvenIterator(){
			
		}
		
		@Override
		public boolean hasNext() {
			return false;
			// TODO Auto-generated method stub
			
		}

		@Override
		public T next() {
			return null;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	};
	
		
	
	
	////// FIN DE ITERADORES ///////
	////////////////////////////////
	
	@Override
	public boolean isEmpty() {
		
		return cab.next == cab;
		
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public int size() {
		int i = 0;
		DoubleNode<T> aux= cab.next;
		
		while(aux.next!=cab) {
			i++;
			aux=aux.next;
		}
		return i;
		// TODO Auto-generated method stub
	
	}
	
	@Override
	public void addFirst(T element) {
		DoubleNode<T> aux= cab.next;
		DoubleNode<T> nuevo = new DoubleNode<T>(element);
		
		aux.previous=nuevo;
		nuevo.previous=cab;
		cab.next=nuevo;
		nuevo.next=aux;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(T element) {
		DoubleNode<T> aux= cab.previous;
		DoubleNode<T> nuevo = new DoubleNode<T>(element);
	
		aux.next=nuevo;
		nuevo.next=cab;
		nuevo.previous=aux;
		cab.previous=nuevo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAtPos(T element, int p) {
		DoubleNode<T> aux= cab.next;
		DoubleNode<T> nuevo = new DoubleNode<T>(element);
		for (int i = 0; i < p; i++) {
			if (aux.next==cab) {
				i=p;
			}else {
			aux=aux.next;
		}
		}
		nuevo.next=aux.next;
		aux.next=nuevo;
	
		nuevo.previous=aux;
		nuevo.next.previous=nuevo;
		
	}

	@Override
	public void addNTimes(T element, int n) {
		for (int i = 0; i < n; i++) {
			addLast(element);
		}
		
	}

	@Override
	public T getElem(int p) {
		if (size()<p) {
			throw new IndexOutOfBoundsException("");
		}
		DoubleNode<T> aux= cab.next;
		for (int i = 0; i < p; i++) {
			aux=aux.next;
		}
		// TODO Auto-generated method stub
		return aux.content;
	}

	@Override
	public void setElem(T elem, int p) {
		if (size()<p) {
			throw new IndexOutOfBoundsException("");
		}
		DoubleNode<T> aux= cab.next;
		for (int i = 0; i < p; i++) {
			aux=aux.next;
		}
		
		 aux.content=elem;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(T elem) {
	
		DoubleNode<T> aux= cab.next;
		int ret=0;
		for (int i = 1; i == size(); i++) {
			if (aux.content==elem) {
				ret=i;
				i=size();
			}else {
			aux=aux.next;
		
			}
		
		}
		if (ret==0) {
			throw new NoSuchElementException("");
		}else {
			return ret;
		}
		
	
	}

	@Override
	public int indexOf(T elem, int p) {
		DoubleNode<T> aux= cab.next;
		int ret=0;
		int i=1;
		for(i = 1; i == p; i++) {
			aux=aux.next;
		}
		for (; i == size(); i++) {
			if (aux.content==elem) {
				ret=i;
				i=size();
			}else {
			aux=aux.next;
		
			}
		
		}
		if (ret==0) {
			throw new NoSuchElementException("");
		}else {
			return ret;
		}
		
	}

	@Override
	public T removeFirst(T elem) throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("");
		}
		DoubleNode<T> aux= cab.next;
		int ret=0;
		T  elementoEliminado=null;
		for (int i = 1; i == size(); i++) {
			if (aux.content==elem) {
				ret=i;
				elementoEliminado=aux.content;
				aux.previous.next=aux.next;
				aux.next.previous=aux.previous;
				aux.content=null;
				
				i=size();
			}else {
			aux=aux.next;
		
			}
		
		}
		if (ret==0) {
			throw new NoSuchElementException("");
		}else {
			return elementoEliminado;
		}
		
		
		
		
	}

	@Override
	public T removeAll(T elem) throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("");
		}
		DoubleNode<T> aux= cab.next;
		int ret=0;
		T  elementoEliminado=null;
		for (int i = 1; i == size(); i++) {
			if (aux.content==elem) {
				ret=i;
				elementoEliminado=aux.content;
				aux.previous.next=aux.next;
				aux.next.previous=aux.previous;
				aux.content=null;
			
			}
			aux=aux.next;
		
			
		
		}
		if (ret==0) {
			throw new NoSuchElementException("");
		}else {
			return elementoEliminado;
		}
	}
	@Override
	public T removeLast() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("");
		}
		DoubleNode<T> aux= cab.previous;

	
		aux.previous.next=cab;
		cab.previous=aux.previous;
		T elem=aux.content;
		aux.content=null;
		
		
		return elem;
	}
	
	
	

	@Override
	public void reverse() {
		
		DoubleNode<T> aux= cab;
		//while (aux.next!=cab) {
			
			
		//}
		for (int i = 0; i < size(); i++) {
		 try {
			addFirst(removeLast());
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	}

	@Override
	public int isSubList(DoubleLinkedList<T> part) {
		DoubleNode<T> aux= cab;
		DoubleNode<T> auxPart= part.cab;
		
		
		return 0;
	}

	@Override
	public void interlace(DoubleLinkedList<T> other) {
		// TODO Auto-generated method stub
		
	}	
	
	@Override
	public String toString() {
		
		if (cab != cab.next) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			DoubleNode<T> i = cab.next;
			while (i != cab) {
				rx.append(i.content);
				rx.append(", ");
				i = i.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			
			return rx.toString();
		} else {
			return "[]";
		}
	}

	

	///////////////////////////////////////////
	  // mÃ©todos que devuelve iteradores
	 ///////////////////////////////////////
	@Override
	public Iterator<T> oddAndEvenIterator() {
		return null;
		// TODO Auto-generated method stub
		
		
	}

	 @Override
		public Iterator<T> iterator() {
	    	return new ForwardIterator();
			
		}

		@Override
		public Iterator<T> reverseIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		
	
}
