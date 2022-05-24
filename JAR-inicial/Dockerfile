
FROM alpine:latest
WORKDIR /app
COPY ./Project Files/pom.xml
COPY . .
EXPOSE 8080
CMD ["/bin/sh", 'java', '-jar', 'Swing-1.0-SNAPSHOT-jar-with-dependencies.jar']
