FROM quay.io/keycloak/keycloak:25.0.1 as builder

ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true
ENV KEYCLOAK_ADMIN=admin
ENV KEYCLOAK_ADMIN_PASSWORD=secret
ENV KC_BOOTSTRAP_ADMIN_USERNAME=admin
ENV KC_BOOTSTRAP_ADMIN_PASSWORD=secret

WORKDIR /opt/keycloak

RUN keytool -genkeypair -v -keystore /opt/keycloak/keystore.p12 -storetype PKCS12 -keyalg RSA -keysize 2048 -validity 3650 -alias keycloak -dname "CN=localhost, OU=Keycloak, O=Keycloak, L=SomeCity, ST=SomeState, C=US" -storepass password -keypass password

RUN /opt/keycloak/bin/kc.sh build

FROM quay.io/keycloak/keycloak:25.0.1

COPY --from=builder /opt/keycloak/ /opt/keycloak/
COPY ./realm.json /opt/keycloak/bin/

RUN /opt/keycloak/bin/kc.sh import --file /opt/keycloak/bin/realm.json && rm /opt/keycloak/bin/realm.json

EXPOSE 8080 8443

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev"]
