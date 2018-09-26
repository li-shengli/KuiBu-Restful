package com.selfstudy.kuibu.vo;

public enum Gender {

	MAN(0, 'M'), FEMALE(1, 'F');

	private int value;
	
	private char gender;

	private Gender(int value, char gender) {
		this.value = value;
		this.gender = gender;
	}

	public int value() {
		return value;
	}
	
	public static int getIntValue(char gender) {
		if (gender == 'M') {
			return 0;
		}
		return 1;
	}
	
	public char getGender() {
		return gender;
	}

	public static Gender get(int value) {
		for (Gender gender : Gender.values()) {
			if (gender.value() == value) {
				return gender;
			}
		}
		return null;
	}
}
