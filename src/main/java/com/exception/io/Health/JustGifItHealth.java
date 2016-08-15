package com.exception.io.Health;

import com.justgifit.JustGifItProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Fausto on 8/15/2016.
 */
@Component
public class JustGifItHealth implements HealthIndicator {

    @Inject
    private JustGifItProperties properties;

    @Override
    public Health health() {
        if(properties.getGifLocation().canWrite()) {
            return Health.up().build();
        }else{
            return Health.down().build();
        }
    }
}
