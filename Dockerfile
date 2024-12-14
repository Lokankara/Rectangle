FROM quay.io/keycloak/keycloak:25.0.1 as builder

# Enable health and metrics support
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

# Set the bootstrap admin user credentials
ENV KC_BOOTSTRAP_ADMIN_USERNAME=admin
ENV KC_BOOTSTRAP_ADMIN_PASSWORD=secret

# Set the keycloak hostname (optional, depending on your needs)
# ENV KC_HOSTNAME=lokankara.rectangle.in

WORKDIR /opt/keycloak

# Generate server keystore
RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore

# Build Keycloak
RUN /opt/keycloak/bin/kc.sh build

# Final image for runtime
FROM quay.io/keycloak/keycloak:25.0.1

# Copy the built Keycloak from the builder image
COPY --from=builder /opt/keycloak/ /opt/keycloak/

# Copy the realm configuration file
COPY ./realm.json /opt/keycloak/bin/

# Import the realm configuration
RUN /opt/keycloak/bin/kc.sh import --file /opt/keycloak/bin/realm.json && rm /opt/keycloak/bin/realm.json

# Expose the necessary port for Keycloak
EXPOSE 8080

# Set the default entry point to start Keycloak in development mode
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]

# Start Keycloak
CMD ["start-dev"]
