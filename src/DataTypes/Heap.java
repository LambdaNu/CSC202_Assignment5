package DataTypes;

import java.util.ArrayList;




public class Heap<T extends Comparable<T>> { 
	private ArrayList<T> arr;
	private int size; 
	//private int size;  //these really didn't work for me...
	//private int lastindex;
	//private int falsemax; 
	//boolean maxInPlay;
	//private static final int DEFAULTSIZE = 10;
	public Heap(){
		setArr(new ArrayList<T>());
	}
	public Heap(ArrayList<T> x){
		this.setArr(x); 
		heapify();
	}
	public boolean isEmpty(){return getArr().size() == 0; }
	public int size(){return getArr().size();}

    public void add(T item) {
        getArr().add(item);
        size = getArr().size() - 1;
        int pNode = getpNode(size);
        while (pNode != size && getArr().get(size).compareTo(getArr().get(pNode)) <0) {
            transpose(size, pNode);
            size = pNode;
            pNode = getpNode(size);
        }
    }
	
	public T remove() throws ADTExceptions{
		 if (getArr().size() == 0) {
	            throw new ADTExceptions("Cannot remove on empty heap.");
	        } else if (getArr().size() == 1) {
	            T min = getArr().remove(0);
	            return min;
	        }
	        T min = getArr().get(0);
	        T lastItem = getArr().remove(getArr().size() - 1);
	        getArr().set(0, lastItem);
	        minHeapify(0);
	        return min;
	}
	public String toString(){
		String returnval = getArr().toString(); 
		return returnval; 
	}
	
	private void heapify(){
	     for (int i = getArr().size() / 2; i >= 0; i--) {
	            minHeapify(i);
	        }
	}
	  private void minHeapify(int i) {
	        int left = getleft(i);
	        int right = getright(i);
	        int smallest = -1;
	        if (left <= getArr().size() - 1 && getArr().get(left).compareTo(getArr().get(i)) < 0 ) {
	            smallest = left;
	        } else {
	            smallest = i;
	        }
	        if (right <= getArr().size() - 1 && getArr().get(right).compareTo(getArr().get(smallest)) < 0 ) {
	            smallest = right;
	        }
	        if (smallest != i) {
	            transpose(i, smallest);
	            minHeapify(smallest);
	        }
	    }
	  	private int getleft(int n) {return (n * 2 + 1);}
		private int getright(int n) {return (n * 2 + 2);}
		private int getpNode(int i) {return i/2;}
	    private void transpose(int i, int pNode) {
	        T temp = getArr().get(pNode);
	        getArr().set(pNode, getArr().get(i));
	        getArr().set(i, temp);
	    }
		public ArrayList<T> getArr() {
			return arr;
		}
		public void setArr(ArrayList<T> arr) {
			this.arr = arr;
		}

		 
}
