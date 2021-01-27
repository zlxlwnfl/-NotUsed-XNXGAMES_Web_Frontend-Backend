FROM java:8
LABEL owner="kimjuri"

EXPOSE 8080
ARG JAR_FILE=target/UI-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} ui.jar

ENTRYPOINT [ "java", "-jar", "/ui.jar" ]