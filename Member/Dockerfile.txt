FROM java:8
LABEL owner="kimjuri"

EXPOSE 8081
ARG JAR_FILE=target/Member-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} member.jar

ENTRYPOINT [ "java", "-jar", "/member.jar" ]