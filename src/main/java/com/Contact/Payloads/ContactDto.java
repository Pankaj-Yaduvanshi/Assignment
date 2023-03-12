package com.Contact.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDto {
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String phone;

}
