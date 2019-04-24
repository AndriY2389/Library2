package com.softserve.service;

import com.softserve.dto.ReaderDTO;
import com.softserve.model.Reader;

import java.util.List;

public interface ReaderService {

    boolean save(Reader entity);

    boolean delete(Reader entity);

    List<Reader> findAll();

    boolean update(Reader entity);

    Reader findById(Integer id);

    boolean deleteById(Integer id);

    boolean isReaderInputRigth(ReaderDTO entity);
}
