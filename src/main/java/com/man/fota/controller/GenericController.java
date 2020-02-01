package com.man.fota.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

public class GenericController {

	final static String DEFAULT_PAGE_SIZE = "100";
	
	HttpHeaders setHeaders(Page<?> page) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("page", String.valueOf(page.getNumber()));
        headers.add("pageSize", String.valueOf(page.getNumberOfElements()));
        headers.add("totalElements", String.valueOf(page.getTotalElements()));
        headers.add("totalPages", String.valueOf(page.getTotalPages()));
        return headers;
	}
	
}
