FROM openjdk:latest
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle
COPY gradlew.bat .
COPY . /app
RUN ./gradlew build
CMD ["java", "-cp", "/app/build/classes:/app/build/libs/*", "com.amaap.marsrover.Main"]