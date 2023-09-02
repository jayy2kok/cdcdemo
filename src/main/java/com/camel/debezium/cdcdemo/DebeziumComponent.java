package com.camel.debezium.cdcdemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.debezium.DebeziumConstants;
import org.springframework.stereotype.Component;

@Component
public class DebeziumComponent extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("debezium-mongodb:dbz-test-1").autoStartup(true)
                .log("Event received from Debezium : ${body}")
                .log("    with this identifier ${headers.CamelDebeziumIdentifier}")
                .log("    with these source metadata ${headers.CamelDebeziumSourceMetadata}")
                .log("    the event occured upon this operation '${headers.CamelDebeziumSourceOperation}'")
                .log("    on this database '${headers.CamelDebeziumSourceMetadata[db]}' and this table '${headers.CamelDebeziumSourceMetadata[table]}'")
                .log("    with the key ${headers.CamelDebeziumKey}")
                // .choice()
                // .when(header(DebeziumConstants.HEADER_OPERATION).in("c", "u", "r"))
                // .unmarshal().json()
                // .log("Event received from Debezium : ${body}")
                // .end()
                .end();
    }

}
