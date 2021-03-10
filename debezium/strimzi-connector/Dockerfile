FROM strimzi/kafka:0.20.1-kafka-2.6.0
USER root:root
RUN mkdir -p /opt/kafka/plugins/debezium
RUN curl -L https://repo1.maven.org/maven2/io/debezium/debezium-connector-mysql/1.5.0.Beta1/debezium-connector-mysql-1.5.0.Beta1-plugin.tar.gz \
    | tar -xzvf - -C /opt/kafka/plugins/debezium && mv /opt/kafka/plugins/debezium/debezium-connector-mysql/* /opt/kafka/plugins/debezium \
    && rm -rf /opt/kafka/plugins/debezium/debezium-connector-mysql
RUN curl -L https://repo1.maven.org/maven2/io/debezium/debezium-connector-sqlserver/1.5.0.Beta1/debezium-connector-sqlserver-1.5.0.Beta1-plugin.tar.gz \
    | tar -xzvf - -C /opt/kafka/plugins/debezium && mv /opt/kafka/plugins/debezium/debezium-connector-sqlserver/* /opt/kafka/plugins/debezium \
    && rm -rf /opt/kafka/plugins/debezium/debezium-connector-sqlserver
USER 1001