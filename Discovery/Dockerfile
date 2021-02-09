FROM java:8
LABEL owner="kimjuri"

EXPOSE 8761
ARG JAR_FILE=target/Discovery-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} discovery.jar

ENTRYPOINT [ "java", "-jar", "/discovery.jar" ]