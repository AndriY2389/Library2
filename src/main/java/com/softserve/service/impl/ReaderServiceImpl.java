package com.softserve.service.impl;

import com.softserve.dao.generic.ReaderDAO;
import com.softserve.model.Reader;
import com.softserve.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderDAO readerDAO;

    @Override
    @Transactional
    public boolean save(Reader entity) {
        if (isReaderInputRigth(entity)) {
            readerDAO.save(entity);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Reader entity) {
        readerDAO.delete(entity);
        return true;
    }

    @Override
    public List<Reader> findAll() {
        return readerDAO.findAll();
    }

    @Override
    @Transactional
    public boolean update(Reader entity) {
        if (isReaderInputRigth(entity)) {
            readerDAO.update(entity);
        }
        return false;
    }

    @Override
    public Reader findById(Integer id) {
        return readerDAO.findById(id);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        readerDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean isReaderInputRigth(Reader entity) {
        Pattern pattern = Pattern.compile("[A-Za-z]+[ -]?[A-Za-z]+");
        Matcher firstNameMatcher = pattern.matcher(entity.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(entity.getLastName());
        if (firstNameMatcher.matches() && lastNameMatcher.matches()) {
            return true;
        }
        return false;
    }
}
