class SmallestInfiniteSet {

 private int capacity;
	private int size = 0;
	int[] items;

	public SmallestInfiniteSet() {
	    this.capacity = 1000;
	    this.size = 1000;
	    this.items = new int[this.capacity];
	    for (int i = 0; i < size; i++) {
	        items[i] = (i + 1);
	    }

	    // Build the heap
	    for (int i = size / 2 - 1; i >= 0; i--) {
	        heapifyDown(i);
	    }
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	private void checkExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			this.capacity *= 2;
		}
	}

	public int popSmallest() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int ret = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown(0);
		return ret;
	}

	private void heapifyDown(int index) {
	    int smallest = index;

	    if (hasLeftChild(index) && leftChild(index) < items[smallest]) {
	        smallest = getLeftChildIndex(index);
	    }
	    if (hasRightChild(index) && rightChild(index) < items[smallest]) {
	        smallest = getRightChildIndex(index);
	    }

	    if (smallest != index) {
	        swap(index, smallest);
	        heapifyDown(smallest); // Recursively heapify the affected subtree
	    }
	}
	
	private void heapifyUp() {
	    int index = size - 1;
	    while (hasParent(index) && parent(index) > items[index]) {
	        swap(index, getParentIndex(index));
	        index = getParentIndex(index);
	    }
	}


	public void addBack(int num) {
	    // Prevent duplicate addition or invalid values
	    if (num < 1 || num > 1000 || contains(num)) {
	        return;
	    }

	    checkExtraCapacity();
	    items[size] = num;
	    size++;
	    heapifyUp();
	}

	// Helper method to check if a value is already in the heap
	private boolean contains(int num) {
	    for (int i = 0; i < size; i++) {
	        if (items[i] == num) {
	            return true;
	        }
	    }
	    return false;
	}
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
