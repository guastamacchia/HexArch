package org.atsaug.ha.adapter.driver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.atsaug.ha.hexagon.port.driver.BirthdayService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/birthday")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class BirthdayRestApiAdapter {

    private final BirthdayService service;

    @GetMapping
    public void wishHappyBirthday() {
        service.wishHappyBirthday(LocalDate.now());
    }
}