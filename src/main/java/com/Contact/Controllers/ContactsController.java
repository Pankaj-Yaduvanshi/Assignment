package com.Contact.Controllers;

import com.Contact.Payloads.ContactDto;
import com.Contact.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Contact.Payloads.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
    @Autowired
    private ContactService contactService;

    // To create contact
    @PostMapping("/create")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto){
        ContactDto createContact = this.contactService.createContact(contactDto);
        return new ResponseEntity<ContactDto>(createContact, HttpStatus.CREATED);
    }

    // To update contact
    @PutMapping("/update/{id}")
    public ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto, @PathVariable Integer id) {
        ContactDto updatedcontactDto = this.contactService.updateContact(contactDto, id);
        return ResponseEntity.ok(updatedcontactDto);
    }

    // To delete contact
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteContact(@PathVariable Integer id) {
        this.contactService.deleteContact(id);
        return new ResponseEntity(new ApiResponse("Contact deleted successfully", true), HttpStatus.OK);
    }

    // To get single contact by id
    @GetMapping("/read/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Integer id){
        ContactDto contactDto = this.contactService.getContact(id);
        return new ResponseEntity<ContactDto>(contactDto, HttpStatus.OK);
    }

    // To get single contact by id
    @GetMapping("/read")
    public ResponseEntity<List<ContactDto>> getAllContacts(){
        List<ContactDto> contactDtoList = this.contactService.getAllContacts();
        return new ResponseEntity<List<ContactDto>>(contactDtoList, HttpStatus.OK);
    }

    // To search contact by email
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ContactDto>> searchContactByEmail(@PathVariable String keyword){
        List<ContactDto> contactDtoList = this.contactService.searchContactByEmail(keyword);
        return new ResponseEntity<List<ContactDto>>(contactDtoList, HttpStatus.OK);
    }
}
