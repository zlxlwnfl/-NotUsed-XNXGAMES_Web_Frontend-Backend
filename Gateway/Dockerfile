FROM java:8
LABEL owner="kimjuri"

EXPOSE 8000
ARG JAR_FILE=target/Gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} gateway.jar

ENTRYPOINT [ "java", "-jar", "/gateway.jar" ]