# Context and Dependency Injection
This is a Wildfly-Swarm project that uses the following fractions
1. JPA
2. JSF
3. JAX-RS
4. MVC (Ozark)
5. CDI
6. Bean Validation
7. FLyway (Database Migrations)

I have tested it to run successfully in Eclipse by runnig the main class `org.wildfly.swarm.Swarm`.

When I run in IntelliJ, I get stackoverflow error when I access the main route on `\`. Same problem when running
from the commandline using `mvn clean wildfly-swarm:run`.

Let me know if you have been successful running it outside eclipse.