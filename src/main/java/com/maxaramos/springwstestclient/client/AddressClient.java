package com.maxaramos.springwstestclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.maxaramos.springwstest.address.AddAddressRequest;
import com.maxaramos.springwstest.address.AddAddressResponse;
import com.maxaramos.springwstest.address.AddressType;
import com.maxaramos.springwstest.address.DeleteAddressRequest;
import com.maxaramos.springwstest.address.DeleteAddressResponse;
import com.maxaramos.springwstest.address.GetAddressRequest;
import com.maxaramos.springwstest.address.GetAddressResponse;
import com.maxaramos.springwstest.address.ObjectFactory;
import com.maxaramos.springwstest.address.UpdateAddressRequest;
import com.maxaramos.springwstest.address.UpdateAddressResponse;
import com.maxaramos.springwstestclient.model.Address;

@Component
public class AddressClient {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Autowired
	@Qualifier("addressObjectFactory")
	private ObjectFactory objectFactory;

	public Address addAddress(Address address) {
		AddAddressRequest request = objectFactory.createAddAddressRequest();
		request.setAddress1(address.getAddress1());
		request.setAddress2(address.getAddress2());
		request.setCity(address.getCity());
		request.setState(address.getState());
		request.setCountry(address.getCountry());
		request.setZipCode(address.getZipCode());

		AddAddressResponse response = (AddAddressResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public Address getAddress(Long id) {
		GetAddressRequest request = objectFactory.createGetAddressRequest();
		request.setId(id);

		GetAddressResponse response = (GetAddressResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public Address updateAddress(Address address) {
		AddressType addressType = objectFactory.createAddressType();
		addressType.setId(address.getId());
		addressType.setAddress1(address.getAddress1());
		addressType.setAddress2(address.getAddress2());
		addressType.setCity(address.getCity());
		addressType.setState(address.getState());
		addressType.setCountry(address.getCountry());
		addressType.setZipCode(address.getZipCode());

		UpdateAddressRequest request = objectFactory.createUpdateAddressRequest();
		request.setAddress(addressType);

		UpdateAddressResponse response = (UpdateAddressResponse) webServiceTemplate.marshalSendAndReceive(request);
		return fromResponse(response);
	}

	public boolean deleteAddress(Long id) {
		DeleteAddressRequest request = objectFactory.createDeleteAddressRequest();
		request.setId(id);

		DeleteAddressResponse response = (DeleteAddressResponse) webServiceTemplate.marshalSendAndReceive(request);
		return response.isDeleted();
	}

	public static Address fromResponse(AddAddressResponse response) {
		AddressType addressType = response.getAddress();
		Address address = new Address();
		address.setId(addressType.getId());
		address.setAddress1(addressType.getAddress1());
		address.setAddress2(addressType.getAddress2());
		address.setCity(addressType.getCity());
		address.setState(addressType.getState());
		address.setCountry(addressType.getCountry());
		address.setZipCode(addressType.getZipCode());
		return address;
	}

	public static Address fromResponse(GetAddressResponse response) {
		AddressType addressType = response.getAddress();
		Address address = new Address();
		address.setId(addressType.getId());
		address.setAddress1(addressType.getAddress1());
		address.setAddress2(addressType.getAddress2());
		address.setCity(addressType.getCity());
		address.setState(addressType.getState());
		address.setCountry(addressType.getCountry());
		address.setZipCode(addressType.getZipCode());
		return address;
	}

	public static Address fromResponse(UpdateAddressResponse response) {
		AddressType addressType = response.getAddress();
		Address address = new Address();
		address.setId(addressType.getId());
		address.setAddress1(addressType.getAddress1());
		address.setAddress2(addressType.getAddress2());
		address.setCity(addressType.getCity());
		address.setState(addressType.getState());
		address.setCountry(addressType.getCountry());
		address.setZipCode(addressType.getZipCode());
		return address;
	}

}
