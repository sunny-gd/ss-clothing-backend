package first.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import first.DTO.DataRetrivalObj;
import first.DTO.User;
import first.util.DbConnection;

@Repository
public class TestRepository {
	
	@Autowired
	DbConnection dbConnection;
	
	public Boolean getUser(String username) {
		
		//User user = new User();
		Boolean isValid = false;
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username=?");
			preparedStatement.setString(1, username);
			
			ResultSet resultSet =  preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				isValid = true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return isValid;
	}
	
	public Boolean insertUser(User user) {
		Boolean isInserted = false;
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into users(username,password,email) values(?,?,?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			
			Integer rows=preparedStatement.executeUpdate();
			
			isInserted = rows == 1 ? true : false;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return isInserted;
	}
	
	public List<DataRetrivalObj> getProducts(){
		
		List<DataRetrivalObj> outDataList = new ArrayList<>();
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("select * from category_products order by id");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				DataRetrivalObj dataRetrivalObj = new DataRetrivalObj();
				dataRetrivalObj.setId(resultSet.getInt("id"));
				dataRetrivalObj.setCategory_id(resultSet.getInt("category_id"));
				dataRetrivalObj.setName(resultSet.getString("name"));
				dataRetrivalObj.setPrice(resultSet.getInt("price"));
				dataRetrivalObj.setImageUrl(resultSet.getString("imageURL"));
				
				outDataList.add(dataRetrivalObj);
			}
			
			
		}catch(Exception e) {
			System.out.println("Exception in the repository: "+e.getMessage());
		}
		
		return outDataList;
	}
	

}
