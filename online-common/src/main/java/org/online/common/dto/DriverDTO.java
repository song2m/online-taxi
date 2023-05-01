package org.online.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class DriverDTO {

    private Long id;

    private String address;

    private String driverName;

    private String driverPhone;

    private String driverGender;

    private LocalDate driverBirthday;

    private String driverNation;

}
