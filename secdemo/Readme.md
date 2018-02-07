
http://www.edc4it.com/blog/java/understanding-java-security-and-jaas-part-1.html

# Simple security policy

(since java 1.2, before that applet environment introduced their own security manager)

This will fail with security exception:

`java -Djava.security.policy -jar secdemo.jar`

This will not:

`java-jar secdemo.jar  -Djava.security.policy`

This will not, but rightfully so:

`java -Djava.security.policy -Djava.security.policy=secdemo_security.policy -jar secdemo.jar`

# Signed jar

## Server

Create certificate for the jar signer:

`keytool -genkey -alias DemoKEY -keyalg RSA -keystore demo.ks`

Sign the jar:

`jarsigner -keystore demo.ks -storepass 123456 secdemo.jar DemoKEY`

Export the certificate, so user can add it to its truststore:

`keytool -exportcert -keystore demo.ks -alias DemoKEY -file jim.cert`

## Client

User adds the certificate to the truststore:

`keytool -import -alias Jim -keystore truststore.ks -file jim.cert`

Run java with extra security added:

`java -Djava.security.manager -Djava.security.policy=secdemo_security_signed.policy -jar secdemo.jar`

## Warning

Files can be removed from jar and `jarsigner -verify` would not complain

Files can be altered in the jar file and you must verify it with `jarsigner` yourself - it will not be autochecked with
`java -Djava.security.manager`

# Priviledged action

You may give permissions to your own code, but if the calling code has no such permissions, then the action will not be executed.
If you want to care only about your own permissions, use the PriviledgedAction.

Compile the WildCode and call the

`java -Djava.security.manager -Djava.security.policy=secdemo_security.policy -cp secdemo.jar;wildcode.jar ua.lviv.navpil.WildCode`

You will notice that you are able to call the priviledged action, but the usual method will fail with security exeptions.

# Security in general

https://security.stackexchange.com/questions/73156/whats-the-difference-between-x-509-and-pkcs7-certificate
http://www.gtopia.org/blog/2010/02/der-vs-crt-vs-cer-vs-pem-certificates/

 - X.509 - standard, which defines a certificate
 - DER - binary encoding
 - PEM - Base64 encoding (has the `----BEGIN` and `-----END` sections)
 - PKCS#7 - standard to put several certificates together (for example for certificate chain). Helps with PKI (public key infrastructure) 
 There are other PKCS (from 1 to 15). Can also contain data.
 
Certificates may have different extensions, eg .pem, .der, .crt and .cer. Two last ones can be both DER and PEM encoded.

 - view: `openssl x509 -in cert.pem -text -noout`
 - transform: `openssl x509 -in cert.crt -inform der -outform pem -out cert.pem`


# Git

http.sslCaInfo=some_file.pem

The `some_file.pem` is the certificate chain, which we trust. It simply includes several chained certificates.

# TODO

1. Check for permissions on tomcat
2. Machine to machine ssl communication
3. JAAS (http://www.edc4it.com/blog/java/understanding-java-security-and-jaas-part-1.html)
