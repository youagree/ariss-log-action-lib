
package ru.unit.techno.ariss.log.action.lib.resource;

import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.EqualIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unit.techno.ariss.log.action.lib.dto.ActionDto;
import ru.unit.techno.ariss.log.action.lib.entity.Event;
import ru.unit.techno.ariss.log.action.lib.service.ActionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ui/actions")
public class ActionsResource {

    private final ActionService actionService;

    /**
     * path - это поле в энтити
     * params - в базе
     *
     * @return
     */
    @GetMapping
    public Page<ActionDto> filterAction(
            @And({@Spec(path = "eventTime", params = "eventTime", spec = GreaterThanOrEqual.class),
                    @Spec(path = "info", params = "info", spec = EqualIgnoreCase.class),
                    //todo поменять местами
                    @Spec(path = "rfid_label_value", params = "rfidLabelValue", spec = Equal.class),
                    @Spec(path = "gos_number", params = "gosNumber", spec = Equal.class)
            }) Specification<Event> specification, Pageable pageable) {
        return actionService.getActionsWithFilter(specification, pageable);
    }
}