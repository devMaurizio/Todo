# Build
mvn clean package && docker build -t dev.maurizio/Todo .

# RUN

docker rm -f Todo || true && docker run -d -p 8080:8080 -p 4848:4848 --name Todo dev.maurizio/Todo 