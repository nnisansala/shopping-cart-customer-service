FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/shopping-cart

COPY target/shopping-cart-customer-service-1.0.0.jar /opt/shopping-cart/

EXPOSE 7070

ENTRYPOINT ["sh", "-c", "java $JVM_OPTS -jar shopping-cart-customer-service-1.0.0.jar"]