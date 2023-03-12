package com.Contact.Services;

import com.Contact.Payloads.ContactDto;
import java.util.List;

public interface ContactService {
    //    To create contact
    ContactDto createContact (ContactDto contactDto);

    //    To update contact
    ContactDto updateContact(ContactDto contactDto, Integer id);

    //    To delete contact
    void deleteContact(Integer id);

    //    To get contact
    ContactDto getContact(Integer id);

    //    To get all contacts
    List<ContactDto> getAllContacts();

    // search contacts by emailID
    List<ContactDto> searchContactByEmail(String keyword);

}
