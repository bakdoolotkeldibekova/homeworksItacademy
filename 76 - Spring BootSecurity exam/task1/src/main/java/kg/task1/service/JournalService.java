package kg.task1.service;

import kg.task1.entity.Journal;

import java.util.List;

public interface JournalService {
    Journal create(Journal journal);
    List<Journal> getAll();
}
