package ua.lviv.navpil.encoding;

public class WhyExceptionsNotErrorCodes {

    //TOCTTOU

    //Despite conceptual simplicity, TOCTTOU race conditions are difficult to avoid and eliminate.
    // One general technique is to use exception handling instead of checking, under the philosophy of EAFP "It is
    // easier to ask for forgiveness than permission" rather than LBYL "look before you leap" – in this case there is no
    // check, and failure of assumptions to hold are detected at use time, by an exception.[6]
}
