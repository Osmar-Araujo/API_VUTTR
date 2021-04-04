FROM openjdk:11
LABEL maintance="Osmar Araujo Garcao"
VOLUME /tmp
EXPOSE 3000
ADD ./target/VUTTR_API-0.0.1-SNAPSHOT.jar VUTTR_API-0.0.1-SNAPSHOT.jar.original
ENTRYPOINT ["java", "-jar", "/VUTTR_API-0.0.1-SNAPSHOT.jar.original"]