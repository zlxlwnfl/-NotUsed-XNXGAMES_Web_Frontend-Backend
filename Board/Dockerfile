FROM java:8
LABEL owner="kimjuri"

EXPOSE 8082
ARG JAR_FILE=target/Board-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} board.jar

ENTRYPOINT [ "java", "-jar", "/board.jar" ]