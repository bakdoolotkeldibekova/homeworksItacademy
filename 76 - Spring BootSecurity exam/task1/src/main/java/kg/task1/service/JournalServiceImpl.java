package kg.task1.service;

import kg.task1.entity.Journal;
import kg.task1.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal create(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public List<Journal> getAll() {
        return journalRepository.findAll();
    }
}
