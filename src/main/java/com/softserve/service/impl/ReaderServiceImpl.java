package com.softserve.service.impl;

import com.softserve.dao.generic.ReaderDAO;
import com.softserve.dto.AuthorDTO;
import com.softserve.dto.ReaderDTO;
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

     private ReaderDTO readerDTO;

    @Override
    @Transactional
    public boolean save(Reader entity) {
        readerDTO = new ReaderDTO(entity);
        if (conditionCreate(entity) && isReaderInputRigth(readerDTO)) {
            readerDAO.save(entity);
            return true;
        }
        return false;
    }

    private boolean conditionCreate(Reader entity) {
        boolean condition = true;
        if (entity.getFirstName().equals("") || entity.getLastName().equals("")) {
            condition = false;
        }
        return condition;
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
        readerDTO = new ReaderDTO(findById(entity.getId()));
        if (entity.getFirstName().equals("") && entity.getLastName().equals("")) {
            return false;
        }
        if (!entity.getLastName().equals("")) {
            readerDTO.setLastName(entity.getLastName());
        }
        if (!entity.getFirstName().equals("")) {
            readerDTO.setFirstName(entity.getFirstName());
        }
        if (!isReaderInputRigth(readerDTO)) {
            return false;
        }
        readerDAO.update(readerDTO.getReader());
        return true;
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
    public boolean isReaderInputRigth(ReaderDTO entity) {
        Pattern pattern = Pattern.compile("[A-Za-z]+[ -]?[A-Za-z]+");
        Matcher firstNameMatcher = pattern.matcher(entity.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(entity.getLastName());
        return (firstNameMatcher.matches() && lastNameMatcher.matches());
    }
}
