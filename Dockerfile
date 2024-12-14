FROM quay.io/keycloak/keycloak as builder

# Enable health and metrics support
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true
ENV KEYCLOAK_USER=admin
ENV KEYCLOAK_PASSWORD=secret
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=secret
#ENV  KC_HOSTNAME=lokankara.rectangle.in
WORKDIR /opt/keycloak
RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak
COPY --from=builder /opt/keycloak/ /opt/keycloak/
COPY ./realm.json /opt/keycloak/bin/
RUN /opt/keycloak/bin/kc.sh import --file /opt/keycloak/bin/realm.json && rm /opt/keycloak/bin/realm.json
ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev"]
