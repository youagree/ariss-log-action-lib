
package ru.unit.techno.ariss.log.action.lib.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.unit.techno.ariss.log.action.lib.model.MetaObject;

import java.util.Map;

@Data
@Component
@ConfigurationProperties("event")
public class DeviceEventConfig {

    @Getter
    private Map<Long, MetaObject> type;
}