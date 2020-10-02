FROM openjdk:8-alpine

WORKDIR /user/app/

COPY ./target/glaucus-test-0.0.1-SNAPSHOT.jar .

EXPOSE 9090

CMD ["java", "-jar", "glaucus-test-0.0.1-SNAPSHOT.jar"]
