package ua.lviv.navpil.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.function.Consumer;

public class LDAP {

    public static void main(String[] args) throws NamingException {
        testLdaps();
        return;

    }

    private static void test2() throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ldap.forumsys.com:389");
        InitialContext initialCtx = new InitialContext(env);

        LdapContext lookup = (LdapContext)initialCtx.lookup("dc=example,dc=com");
//        Attributes dn = lookup.getAttributes("uid=riemann");
//        LdapContext lookup1 = (LdapContext)lookup.lookup("uid=riemann");
//        System.out.println(lookup1.getNameInNamespace());
//        System.out.println(dn);
//        System.out.println(lookup.getNameInNamespace());
        iterate(lookup.getAttributes("").getAll(), System.out::println);

        initialCtx.close();
    }

    private static void testLdaps() throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();

        ldaps://dc.ontime01.dk/dc=ontime01,dc=dk??sub
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://dc.ontime01.dk:389");
        InitialContext initialCtx = new InitialContext(env);

        LdapContext lookup = (LdapContext)initialCtx.lookup("dc=ontime01,dc=dk");
//        Attributes dn = lookup.getAttributes("uid=riemann");
//        LdapContext lookup1 = (LdapContext)lookup.lookup("uid=riemann");
//        System.out.println(lookup1.getNameInNamespace());
//        System.out.println(dn);
//        System.out.println(lookup.getNameInNamespace());
        iterate(lookup.getAttributes("").getAll(), System.out::println);

        initialCtx.close();
    }

    private static void test1() throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ldap.forumsys.com:389");

        InitialContext context = new InitialContext(env);

        Context example = getContext();

        DirContext mathematitians = (DirContext) example.lookup("ou=mathematicians");
        Attributes attributes = mathematitians.getAttributes("");
        Attribute uniqueMember = attributes.get("uniqueMember");
        iterate(uniqueMember.getAll(), (name) -> {
            try {
                NamingEnumeration<? extends Attribute> all = ((DirContext) context.lookup((String) name)).getAttributes("").getAll();
                showAll(all);
                System.out.println();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        });

        context.close();
    }


    private static <T> void showAll(NamingEnumeration<T> all) throws NamingException {
        iterate(all, System.out::println);
    }

    private static <T> void iterate(NamingEnumeration<T> list, Consumer<T> o) throws NamingException {
        while (list.hasMore()) {
            T next = list.next();
            o.accept(next);
        }
    }

    private static Context getContext() throws NamingException {
        Hashtable<String, Object> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ldap.forumsys.com:389");

        InitialContext context = new InitialContext(env);
        return  (Context) context.lookup("dc=example,dc=com");
    }


}
