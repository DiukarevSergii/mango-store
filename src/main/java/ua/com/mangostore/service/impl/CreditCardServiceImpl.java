package ua.com.mangostore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mangostore.entity.CreditCard;
import ua.com.mangostore.repository.CreditCardRepository;
import ua.com.mangostore.service.CreditCardService;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    @Transactional
    public CreditCard addProduct(CreditCard creditCard) {
        CreditCard saveCreditCard = creditCardRepository.saveAndFlush(creditCard);
        return saveCreditCard;
    }

    @Override
    @Transactional
    public void delete(long id) {
        creditCardRepository.delete(id);
    }

    @Override
    @Transactional
    public CreditCard getById(long id) {
        return creditCardRepository.findById(id);
    }

    @Override
    @Transactional
    public CreditCard editProduct(CreditCard creditCard) {
        return creditCardRepository.saveAndFlush(creditCard);
    }

    @Override
    @Transactional
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }
}
