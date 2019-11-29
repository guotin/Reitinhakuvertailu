package application.datastructures;

/**
 * Class for priorityqueue implementation with binary heap. Can only be used
 * with 'Pair' -class as input.
 */
public class PriorityQueue {

    private Pair[] queue;
    private int nextFreeIndex;
    private int elementCount;

    /**
     * Constructor that sets the initial size to 5. First element (index 0) is
     * never used and is filled.
     */
    public PriorityQueue() {
        this.queue = new Pair[5];
        this.queue[0] = new Pair(new Position(1, 1), Integer.MIN_VALUE);
        this.elementCount = 0;
        this.nextFreeIndex = 1;
    }

    /**
     * Doubles the current queue size and copies the elements.
     */
    private void increaseSize() {
        Pair[] newQueue = new Pair[queue.length * 2];
        for (int i = 0; i < queue.length; i++) {
            newQueue[i] = copyPair(queue[i]);
        }
        nextFreeIndex = queue.length;
        queue = newQueue;
    }

    /**
     * Adds a new 'Pair' to the priorityqueue. Negative values (distance) not
     * allowed.
     *
     * @param pair is the pair to be added.
     */
    public void add(Pair pair) {
        if (pair.getDistance() < 0) {
            return;
        }
        if (isFull()) {
            increaseSize();
        }
        queue[nextFreeIndex] = pair;
        nextFreeIndex++;
        elementCount++;
        addAjust();
    }

    /**
     * Method that adjust the heap back to min-heap condition after adding a new
     * element.
     */
    private void addAjust() {
        int currentIndex = elementCount;
        int parentIndex = parent(currentIndex);

        while (queue[parentIndex].getDistance() > queue[currentIndex].getDistance()) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = parent(currentIndex);
        }
    }

    /**
     * Removes and returns the head of the min-heap.
     * @return is the Pair object returned.
     */
    public Pair remove() {
        Pair head = copyPair(queue[1]);
        queue[1] = copyPair(queue[elementCount]);
        queue[elementCount] = null;
        nextFreeIndex--;
        elementCount--;
        if (elementCount > 0) {
            removeAdjust();
        }
        return head;
    }

    /**
     * Adjust the heap back to min-heap condition starting from the root
     * after removal of the head.
     */
    private void removeAdjust() {      
        int index = 1;
        while (leftChild(index) <= elementCount) {
            int minValueIndex = minChild(index);           
            if (queue[index].getDistance() > queue[minValueIndex].getDistance()) {
                swap(index, minValueIndex);
            }          
            index = minValueIndex;
        }
    }
    
    /**
     * Calculates the index of the child with the lowest value.
     * @param index is the index
     * @return child index
     */
    private int minChild(int index) {
        if (rightChild(index) > elementCount) {
            return leftChild(index);
        } else {
            if (queue[leftChild(index)].getDistance() < queue[rightChild(index)].getDistance()) {
                return leftChild(index);
            } else {
                return rightChild(index);
            }
        }
    }

    /**
     * Swaps 2 elements in the heap .
     *
     * @param index1 index of first element.
     * @param index2 index of second element.
     */
    private void swap(int index1, int index2) {
        Pair temp = copyPair(queue[index1]);
        queue[index1] = copyPair(queue[index2]);
        queue[index2] = temp;
    }

    /**
     * Check whether priorityqueue is full.
     *
     * @return full or not.
     */
    private boolean isFull() {
        return elementCount == queue.length - 1;
    }

    /**
     * Calculates the parent index of given index.
     *
     * @param index is the index.
     * @return parent index.
     */
    private int parent(int index) {
        return index / 2;
    }

    /**
     * Calculates the right child index of given index.
     *
     * @param index is the index.
     * @return right child index.
     */
    private int rightChild(int index) {
        return index * 2 + 1;
    }

    /**
     * Calculates the left child index of given index.
     *
     * @param index is the index.
     * @return left child index.
     */
    private int leftChild(int index) {
        return index * 2;
    }

    /**
     * Copies Pair object.
     *
     * @param pair is the pair to be copied.
     * @return copy of pair.
     */
    private Pair copyPair(Pair pair) {
        Position positionCopy = new Position(pair.getPosition().getX(), pair.getPosition().getY());
        int distance = pair.getDistance();
        return new Pair(positionCopy, distance);
    }

    public Pair[] getQueue() {
        return queue;
    }

    public int getElementCount() {
        return elementCount;
    }

    public boolean isEmpty() {
        return (elementCount == 0);
    }

}
