package ua.lviv.navpil.jndi;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.util.Hashtable;

public class FileSys {

    /*
     * Won't work
     */
    public static void main(String[] args) throws NamingException {
        Hashtable ht = new Hashtable();

        ht.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        ht.put(Context.PROVIDER_URL, "file:///D:\\info\\jndi-test");

        Context context = new InitialContext(ht);

        NamingEnumeration ne = context.listBindings("");
        while (ne.hasMore()) {
            Binding next = (Binding)ne.next();
            System.out.println(next.getName() +" " + next.getObject());
        }
        context.close();
    }
}
