package com.archives.workflow.auth.ObjectAuth;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAuth {
    private String name;
    private String email;
    private String password;
    private String rol;
    private Date datetime;
}
