package com.sirp.incident.incident.helper;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class IncidentNumberGeneratorImpl implements IncidentNumberGenerator {

    @Override
    public String generate() {
        return "INC-" + LocalDate.now().getYear() + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}