package application.datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    private Stack stack;
    
    @Before
    public void setUp() {
        this.stack = new Stack();
    }
    
    @Test
    public void stackAddingWorks() {
        stack.add(new Position(1,2));
        stack.add(new Position(2,2));
        stack.add(new Position(1,3));
        assertEquals(3, stack.getElementCount());
    }
    
    @Test
    public void stackIncreasesSizeWhenFull() {
        stack.add(new Position(1,2));
        stack.add(new Position(2,2));
        stack.add(new Position(1,3));
        stack.add(new Position(1,2));
        stack.add(new Position(2,2));

        assertEquals(5, stack.getStack().length);      
        stack.add(new Position(1,2));
        assertEquals(10, stack.getStack().length);
    }
    
    @Test
    public void stackPopsCorrectPosition1() {
        stack.add(new Position(1,2));
        stack.add(new Position(2,2));
        stack.add(new Position(1,3));
        
        Position popped = stack.pop();
        assertEquals(1, popped.getX());
        assertEquals(3, popped.getY());
    }
    
    @Test
    public void stackPopsCorrectPosition2() {
        stack.add(new Position(1,2));
        stack.add(new Position(2,2));
        stack.add(new Position(1,3));
        stack.add(new Position(1,3));
        stack.add(new Position(1,3));
        stack.add(new Position(1,3));
        stack.add(new Position(5,5));
        
        Position popped = stack.pop();
        assertEquals(5, popped.getX());
        assertEquals(5, popped.getY());
    }
    
    @Test
    public void poppedPositionIsRemovedFromStack() {
        for (int i = 0; i < 50; i++) {
            stack.add(new Position(i,i));
        }      
        Position popped = stack.pop();
        assertEquals(49, popped.getX());
        assertEquals(49, popped.getY());
        popped = stack.pop();
        assertEquals(48, popped.getX());
        assertEquals(48, popped.getY());
    }
}
