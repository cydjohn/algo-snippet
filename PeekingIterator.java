// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

// Solution 1:
class PeekingIterator implements Iterator<Integer> {
	private Integer ptr;
	private Iterator<Integer> it;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;	 
	    ptr = it.hasNext()?it.next():null;   
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return ptr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ret = ptr;
	    ptr = it.hasNext()?it.next():null;
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return (ptr != null);
	}
}

//Bad Solution:
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	private Integer ptr;
	private Iterator<Integer> i;
	private Iterator<Integer> k;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    i = iterator;	 
	    k = iterator;
	    ptr = k.hasNext()?k.next():null;  
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		Integer ret = ptr;
		Iterator<Integer> t = i; //It takes a large amount of time here
		ptr = t.hasNext()?t.next():null;
        return ret;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return i.next();
	}

	@Override
	public boolean hasNext() {
	    return i.hasNext();
	}
}