package com.vt.vthacks.model.impl;

import com.vt.vthacks.model.IContactMethod;

public class ContactMethod implements IContactMethod {

	private String name;
	private ContactMethodType type;

	public ContactMethod(ContactMethodType type, String name) {
		this.name = name;
		this.type = type;
	}

	@Override
	public ContactMethodType getType() {
		return type;
	}

	@Override
	public String getName() {
		return name;
	}

}