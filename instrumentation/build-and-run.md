# How to run

Either add `-add-opens java.base/java.lang=ALL-UNNAMED` to VM options the Run configurations in you IDE.

Or do the following:

    mvn clean package
    mvn dependency:copy-dependencies
    java --add-opens java.base/java.lang=ALL-UNNAMED -cp target/instr-1.0-SNAPSHOT.jar;target/dependency/* ua.lviv.navpil.instr.Main

