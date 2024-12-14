FROM quay.io/keycloak/keycloak:25.0 as builder

# Enable health and metrics support
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

# Configure a database vendor
# ENV KC_DB=postgres

WORKDIR /opt/keycloak
RUN /opt/keycloak/bin/kc.sh build

FROM openjdk:21-bookworm
COPY --from=builder /opt/keycloak/ /opt/keycloak/
COPY ./realm.json /opt/keycloak/bin/
RUN apt-get -y update && apt-get -y install curl
USER root
RUN adduser --uid 1000 --disabled-password --gecos "" --no-create-home keycloak
RUN chown -R keycloak /opt
RUN chmod -R u+rwx /opt

USER keycloak
ENV KEYCLOAK_IMPORT=/opt/keycloak/bin/realm.json
ENV KC_FEATURES=token-exchange
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]
CMD ["start-dev"]
