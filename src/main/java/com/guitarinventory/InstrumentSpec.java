package com.guitarinventory;

import java.util.Map;

public class InstrumentSpec {
    private Map<String, Object> properties;

    InstrumentSpec(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Object getProperty(Object key) {
        return properties.get(key);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!properties.get("instrumentType").equals(otherSpec.getProperties().get("instrumentType"))) {
            return false;
        }

        Map<String, Object> props = otherSpec.getProperties();
        for (String key : props.keySet()) {
            if (!key.equalsIgnoreCase("instrumentType") &&
                properties.containsKey(key) && properties.get(key).equals(props.get(key))) {
                return true;
            }
        }

        return false;
    }
}
