package navpil.utest;

import org.easymock.EasyMock;
import org.mockito.Mockito;

public class MyClassTest {
    @org.junit.Test
    public void getNumber() throws Exception {
        MyClass mock = Mockito.mock(MyClass.class);

        Mockito.when(mock.getNumber()).thenReturn(5);

        System.out.println(mock.getNumber());

        MyClass mock1 = EasyMock.createMock(MyClass.class);

        EasyMock.expect(mock1.getNumber()).andReturn(6);
        EasyMock.replay(mock1);

        System.out.println(mock1.getNumber());
    }

}