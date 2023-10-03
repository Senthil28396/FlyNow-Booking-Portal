package com.springsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.Passanger;
import com.springsecurity.exception.PassangerNotFoundException;
import com.springsecurity.repository.PassangersRepository;


@Service
public class PassangerService {
	
		

		private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
		@Autowired
		private PassangersRepository passangerRepository;
		
		public List<Passanger> getAllPassangers() throws PassangerNotFoundException{
			List<Passanger> passanger=(List<Passanger>) passangerRepository.findAll();
			if(passanger!=null) {
				return passanger;
			}
			else
			{ 
				throw new PassangerNotFoundException("no passanger records found");
			}
		}
		public Passanger getPassanger(long id) throws PassangerNotFoundException
		{
			Optional<Passanger> passangers=passangerRepository.findById(id);
			if(passangers.isPresent()) {
				Passanger passanger=passangers.get();
				return passanger;
			}
			else {
				throw new PassangerNotFoundException("Passanger not exist"+id);
			}
		}
		public void updatePassanger(Passanger passanger,long id) throws PassangerNotFoundException {
		Optional<Passanger> passangr=passangerRepository.findById(id);
		if(passangr.isPresent()) {
			Passanger passangrs=passangr.get();
			if(passanger.getFirstName()!=null)
				passangrs.setFirstName(passanger.getFirstName());
			if(passanger.getLastName()!=null)
				passangrs.setLastName(passanger.getLastName());
			if(passanger.getAddress()!=null)
				passangrs.setAddress(passanger.getAddress());
			if(passanger.getPassword()!=null)
				passangrs.setPassword(passanger.getPassword());
			if(passanger.getGender()!=null)
				passangrs.setGender(passanger.getGender());
			if(passanger.getPhoneNumber()!=null)
				passangrs.setPhoneNumber(passanger.getPhoneNumber());
			if(passanger.getEmail()!=null)
				passangrs.setEmail(passanger.getEmail());
			if(passanger.getAge()!=0)
				passangrs.setAge(passanger.getAge());
			if(passanger.getPassportNumber()!=null)
				passangrs.setPassportNumber(passanger.getPassportNumber());
			if(passanger.getNationality()!=null)
				passangrs.setNationality(passanger.getNationality());
			
			passangerRepository.save(passangrs);
		}
		else
		{
			throw new PassangerNotFoundException("not found passanger id:"+id);
		}
	}
	public void deletePassanger(long id) throws PassangerNotFoundException {
		Optional<Passanger> passanger=passangerRepository.findById(id);
		if(passanger.isPresent()) {
			Passanger pass=passanger.get();
			passangerRepository.delete(pass);
		}
		else
		{
			throw new PassangerNotFoundException("no records found for this id"+id);
		}
	}
	
		
}
