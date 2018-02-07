package ua.lviv.navpil.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbDemo {


    //https://javaee.github.io/jaxb-v2/doc/user-guide/ch03.html#deployment
/*
To specify a JAXB (JSR-222) implementation other than the default you need to include a file called  jaxb.properties in the same package as your domain classes. The following is an example of the jaxb.properties file used to specify the MOXy implementation of JAXB:

javax.xml.bind.context.factory=org.eclipse.persistence.jaxb.JAXBContextFactory
For More Information

http://blog.bdoughan.com/2011/05/specifying-eclipselink-moxy-as-your.html
 */

    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(new Person("Jim", 27), writer);

        String marshalled = writer.toString();

        System.out.println(marshalled);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        unmarshallAs(unmarshaller, marshalled, Person.class);
        unmarshallAs(unmarshaller, marshalled, Student.class);

        System.out.println(unmarshaller.unmarshal(new StringReader(marshalled)));
    }

    private static <T> void unmarshallAs(Unmarshaller unmarshaller, String marshalled, Class<T> clazz) throws JAXBException {
        JAXBElement<T> unmarshal = unmarshaller.unmarshal(new StreamSource(new StringReader(marshalled)), clazz);
        System.out.println(unmarshal.getValue());
    }


    @XmlRootElement(name = "Person")
    public static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @XmlRootElement(name = "Student")
    public static class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
