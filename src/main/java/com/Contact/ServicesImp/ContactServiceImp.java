package com.Contact.ServicesImp;

import com.Contact.Payloads.ContactDto;
import com.Contact.Repositories.ContactRepo;
import com.Contact.Services.ContactService;
import com.Contact.enitities.Contact;
import com.Contact.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImp implements ContactService {
    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact = this.modelMapper.map(contactDto, Contact.class);
        Contact addedContact = this.contactRepo.save(contact);
        return this.modelMapper.map(addedContact, ContactDto.class);
    }

    @Override
    public ContactDto updateContact(ContactDto contactDto, Integer id) {
        Contact contact = this.contactRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Contact", "contact id", id));
        contact.setFirstName(contactDto.getFirstName());
        contact.setSecondName(contactDto.getSecondName());
        contact.setEmail(contactDto.getEmail());
        contact.setPhone(contactDto.getPhone());
        Contact updatedContact = this.contactRepo.save(contact);
        return this.modelMapper.map(updatedContact, ContactDto.class);
    }

    @Override
    public void deleteContact(Integer id) {
        Contact contact = this.contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact", "contact id", id));
        this.contactRepo.delete(contact);
    }

    @Override
    public ContactDto getContact(Integer id) {
        Contact contact = this.contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact", "contact id", id));
        return this.modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = this.contactRepo.findAll();
        List<ContactDto> contactDto = contacts.stream().map((contact) -> this.modelMapper.map(contact, ContactDto.class)).collect(Collectors.toList());
        return contactDto;
    }

    @Override
    public List<ContactDto> searchContactByEmail(String keyword) {
        List<Contact> contacts = this.contactRepo.findByEmailContaining(keyword);
        List<ContactDto> contactDto = contacts.stream().map((contact) -> this.modelMapper.map(contact, ContactDto.class)).collect(Collectors.toList());
        return contactDto;
    }
}
