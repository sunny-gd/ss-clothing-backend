package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.DTO.DataRetrivalObj;
import com.example.first.DTO.ProductDetails;
import com.example.first.DTO.ResponseCategories;
import com.example.first.DTO.User;
import com.example.first.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	
	public Boolean getUser(String username) {
		
		Boolean isValid= false;
		
		try {
			isValid = testRepository.getUser(username);
			
		}catch(Exception e) {
			System.out.println("Exception form Service calass and Method:getUser -> "+e.getMessage());
		}
		return isValid;
	}
	
	public Boolean insertUser(User user) {
		Boolean isInserted=false;
		
		try {
			isInserted = testRepository.insertUser(user);
			
		}catch(Exception e) {
			System.out.println("Exception form Service calass and Method:insertUser -> "+e.getMessage());
		}
		return isInserted;
		
	}
	
	public ResponseCategories getProducts() {
		
		List<DataRetrivalObj> outDataList = new ArrayList<>();
		ResponseCategories responseCategories = new ResponseCategories();
		List<ProductDetails> hats = new ArrayList<>();
		List<ProductDetails> jackets = new ArrayList<>();
		List<ProductDetails> mens = new ArrayList<>();
		List<ProductDetails> sneakers = new ArrayList<>();
		List<ProductDetails> womens = new ArrayList<>();
		
		try {
			
			outDataList=testRepository.getProducts();
			
			for(DataRetrivalObj testObj : outDataList) {
				ProductDetails productDetails = new ProductDetails();
				productDetails.setId(testObj.getId());
				productDetails.setName(testObj.getName());
				productDetails.setPrice(testObj.getPrice());
				productDetails.setImageUrl(testObj.getImageUrl());
				
				if(testObj.getCategory_id() == 1) {
					hats.add(productDetails);
				}else if(testObj.getCategory_id() == 2) {
					jackets.add(productDetails);
				}else if(testObj.getCategory_id() == 3) {
					mens.add(productDetails);
				}else if(testObj.getCategory_id() == 4) {
					sneakers.add(productDetails);
				}else if(testObj.getCategory_id() == 5) {
					womens.add(productDetails);
				}
				
			}
			
			responseCategories.setHats(hats);
			responseCategories.setJackets(jackets);
			responseCategories.setMens(mens);
			responseCategories.setSneakers(sneakers);
			responseCategories.setWomens(womens);
			
			
			
		}catch(Exception e) {
			System.out.println("Exception form Service calass and Method:getProducts -> "+e.getMessage());
		}
		
		return responseCategories;
	}
	
	
}
