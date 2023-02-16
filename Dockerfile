FROM gradle:jdk17-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
USER root
RUN chown -R gradle /home/source/java
USER gradle
RUN gradle clean bootJar

FROM gradle:jdk17-alpine
WORKDIR /home/application/java
COPY --from=compile "/home/source/java/build/libs/kube-0.0.1-SNAPSHOT.jar" .
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/home/application/java/kube-0.0.1-SNAPSHOT.jar"]