
package org.mhildenb.cdcdemo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "connector",
    "name",
    "ts_ms",
    "snapshot",
    "db",
    "schema",
    "table",
    "change_lsn",
    "commit_lsn",
    "event_serial_no"
})
public class Source {

    @JsonProperty("version")
    private String version;
    @JsonProperty("connector")
    private String connector;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ts_ms")
    private Long tsMs;
    @JsonProperty("snapshot")
    private String snapshot;
    @JsonProperty("db")
    private String db;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("table")
    private String table;
    @JsonProperty("change_lsn")
    private String changeLsn;
    @JsonProperty("commit_lsn")
    private String commitLsn;
    @JsonProperty("event_serial_no")
    private Long eventSerialNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("connector")
    public String getConnector() {
        return connector;
    }

    @JsonProperty("connector")
    public void setConnector(String connector) {
        this.connector = connector;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ts_ms")
    public Long getTsMs() {
        return tsMs;
    }

    @JsonProperty("ts_ms")
    public void setTsMs(Long tsMs) {
        this.tsMs = tsMs;
    }

    @JsonProperty("snapshot")
    public String getSnapshot() {
        return snapshot;
    }

    @JsonProperty("snapshot")
    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    @JsonProperty("db")
    public String getDb() {
        return db;
    }

    @JsonProperty("db")
    public void setDb(String db) {
        this.db = db;
    }

    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
    }

    @JsonProperty("table")
    public String getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(String table) {
        this.table = table;
    }

    @JsonProperty("change_lsn")
    public String getChangeLsn() {
        return changeLsn;
    }

    @JsonProperty("change_lsn")
    public void setChangeLsn(String changeLsn) {
        this.changeLsn = changeLsn;
    }

    @JsonProperty("commit_lsn")
    public String getCommitLsn() {
        return commitLsn;
    }

    @JsonProperty("commit_lsn")
    public void setCommitLsn(String commitLsn) {
        this.commitLsn = commitLsn;
    }

    @JsonProperty("event_serial_no")
    public Long getEventSerialNo() {
        return eventSerialNo;
    }

    @JsonProperty("event_serial_no")
    public void setEventSerialNo(Long eventSerialNo) {
        this.eventSerialNo = eventSerialNo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
