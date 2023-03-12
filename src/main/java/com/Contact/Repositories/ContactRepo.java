package com.Contact.Repositories;

import com.Contact.enitities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    List<Contact> findByEmailContaining(String email);
}
