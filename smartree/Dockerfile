FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-jar","-Djasypt.encryptor.password=KITCH#KITCH$MAN#GWANBU!","/app.jar"]

