package made.myself.newarraylist.collectionsTest;

import made.myself.newarraylist.collections.MyArrayListImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyArrayListImplTest {

    MyArrayListImpl out = new MyArrayListImpl();
    @Test
    @DisplayName("Проверка логики всей коллекции")
    public void test1()
    {
        assertTrue(out.isEmpty());

        out.add("Test1");
        out.add("Test2");
        out.add("Test3");
        out.add("Test4");

        assertFalse(out.isEmpty());

        assertEquals("Test1",out.get(0));
        assertEquals("Test2",out.get(1));
        assertEquals("Test3",out.get(2));
        assertEquals(1,out.indexOf("Test2"));
        assertEquals(2,out.lastIndexOf("Test3"));


        out.remove(1);

        assertEquals("Test3",out.get(1));

        out.remove("Test3");

        assertEquals("Test4", out.get(1));
        assertEquals(2, out.size());

        out.set(1,"Test2");
        assertEquals("Test2", out.get(1));
    }

    @Test
    @DisplayName("Проверка метода equals")
    public void test2()
    {
        MyArrayListImpl test= new MyArrayListImpl();

        test.add("Test1");
        test.add("test2");

        out.add("Test1");
        out.add("test2");

        assertTrue(out.equals(test));

        out.add("Test3");

        assertFalse(out.equals(test));

        out.remove(2);
        out.set(1,"Test2");

        assertFalse(out.equals(test));
    }
}
