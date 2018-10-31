package com.maxaramos.samplespringwsclient.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.maxaramos.samplespringws.address.AddAddressRequest;
import com.maxaramos.samplespringws.address.AddAddressResponse;
import com.maxaramos.samplespringws.address.AddressType;
import com.maxaramos.samplespringws.address.DeleteAddressRequest;
import com.maxaramos.samplespringws.address.DeleteAddressResponse;
import com.maxaramos.samplespringws.address.GetAddressRequest;
import com.maxaramos.samplespringws.address.GetAddressResponse;
import com.maxaramos.samplespringws.address.GetAllAddressRequest;
import com.maxaramos.samplespringws.address.GetAllAddressResponse;
import com.maxaramos.samplespringws.address.ObjectFactory;
import com.maxaramos.samplespringws.address.UpdateAddressRequest;
import com.maxaramos.samplespringws.address.UpdateAddressResponse;
import com.maxaramos.samplespringwsclient.model.Address;

@Component
public class AddressClient {

	private ObjectFactory objectFactory = new ObjectFactory();

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public List<Address> getAllAddress() {
		GetAllAddressRequest request = objectFactory.createGetAllAddressRequest();

		GetAllAddressResponse response = (GetAllAddressResponse) webServiceTemplate.marshalSendAndReceive(request);
		return response.getAddresses().stream().map(addressType -> fromAddressType(addressType)).collect(Collectors.toList());
	}

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

	public Address fromAddressType(AddressType addressType) {
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
