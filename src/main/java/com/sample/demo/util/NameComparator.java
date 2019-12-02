package com.sample.demo.util;

import java.util.Comparator;

import com.sample.demo.model.StudentBean;

public class NameComparator implements Comparator<StudentBean> {

	@Override
	public int compare(StudentBean o1, StudentBean o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
