package com.maxaramos.springwstestclient.wsclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.maxaramos.springwstest.user.AddUserRequest;
import com.maxaramos.springwstest.user.AddUserResponse;
import com.maxaramos.springwstest.user.DeleteUserRequest;
import com.maxaramos.springwstest.user.DeleteUserResponse;
import com.maxaramos.springwstest.user.GetUserRequest;
import com.maxaramos.springwstest.user.GetUserResponse;
import com.maxaramos.springwstest.user.ObjectFactory;
import com.maxaramos.springwstest.user.UpdateUserRequest;
import com.maxaramos.springwstest.user.UpdateUserResponse;
import com.maxaramos.springwstest.user.UserType;
import com.maxaramos.springwstestclient.model.User;

@Component
public class UserWsClient {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Autowired
	@Qualifier("userObjectFactory")
	private ObjectFactory objectFactory;

	public User addUser(User user) {
		AddUserRequest request = objectFactory.createAddUserRequest();
		request.setUsername(user.getUsername());
		request.setPassword(user.getPassword());

		AddUserResponse response = (AddUserResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public User getUser(Long id) {
		GetUserRequest request = objectFactory.createGetUserRequest();
		request.setId(id);

		GetUserResponse response = (GetUserResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public User updateUser(User user) {
		UserType userType = objectFactory.createUserType();
		userType.setId(user.getId());
		userType.setUsername(user.getUsername());
		userType.setPassword(user.getPassword());

		UpdateUserRequest request = objectFactory.createUpdateUserRequest();
		request.setUser(userType);

		UpdateUserResponse response = (UpdateUserResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public boolean deleteUser(Long id) {
		DeleteUserRequest request = objectFactory.createDeleteUserRequest();
		request.setId(id);

		DeleteUserResponse response = (DeleteUserResponse) webServiceTemplate.marshalSendAndReceive(request);
		return response.isResult();
	}

	public static User fromResponse(AddUserResponse response) {
		UserType userType = response.getUser();
		User user = new User();
		user.setUsername(userType.getUsername());
		user.setPassword(userType.getPassword());
		return user;
	}

	public static User fromResponse(GetUserResponse response) {
		UserType userType = response.getUser();
		User user = new User();
		user.setId(userType.getId());
		user.setUsername(userType.getUsername());
		user.setPassword(userType.getPassword());
		return user;
	}

	public static User fromResponse(UpdateUserResponse response) {
		UserType userType = response.getUser();
		User user = new User();
		user.setId(userType.getId());
		user.setUsername(userType.getUsername());
		user.setPassword(userType.getPassword());
		return user;
	}

}
