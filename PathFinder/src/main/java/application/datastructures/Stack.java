package application.datastructures;

/**
 * Class that implements a stack with Position-class as elements.
 */
public class Stack {
    private Position[] stack;
    private int elementCount;
    
    public Stack() {
        this.stack = new Position[5];
        this.elementCount = 0;
    }
    
    /**
     * Add a new Position to the stack and increases size if the stack is full.
     * @param position is the position to be added.
     */ 
    public void add(Position position) {
        if (isFull()) {
            increaseSize();
        }
        stack[elementCount] = position;
        elementCount++;
    }
    
    /**
     * Removes and returns the last added element of the stack.
     * @return Position object at the top of the stack.
     */
    public Position pop() {
        Position poppedPosition = copyPosition(stack[elementCount-1]);
        elementCount--;
        stack[elementCount] = null;
        return poppedPosition;
    }
    
    /**
     * Doubles the stack size.
     */
    public void increaseSize() {
        Position[] newStack = new Position[stack.length * 2];
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = copyPosition(stack[i]);
        }
        stack = newStack;
    }
    
    private Position copyPosition(Position position) {
        Position newPosition = new Position(position.getX(), position.getY());
        return newPosition;
    }
    
    public boolean isFull() {
        return elementCount == stack.length;
    }

    public int getElementCount() {
        return elementCount;
    }

    public Position[] getStack() {
        return stack;
    }
    
    public boolean isEmpty() {
        return elementCount == 0;
    }   
}
