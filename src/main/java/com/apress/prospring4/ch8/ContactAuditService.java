package com.apress.prospring4.ch8;

import java.util.List;

public interface ContactAuditService {
    List<ContactAudit> findAll();
    ContactAudit findById(Long id);
    ContactAudit save(ContactAudit contactAudit);
    ContactAudit findAuditByRevision(Long id, int revision);
}
