package com.api;

import com.commonutils.GetPropertyValue;
import com.github.dzieciou.testing.curl.CurlRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
		
	public Response response;
	public Map<String, Object> session = new HashMap<String, Object>();
	private static final String CONTENT_TYPE = GetPropertyValue.getPropertyValueObject().getProperyValue("content.type");
	
	public RequestSpecification requestSetup() {	
		RestAssured.reset();
		Options options = Options.builder().logStacktrace().build();
		RestAssuredConfig config = CurlRestAssuredConfigFactory.createConfig(options);
		String baseURL = GetPropertyValue.getPropertyValueObject().getProperyValue("baseURL");
		RestAssured.baseURI = baseURL;
		return RestAssured.given()
				.config(config)
				.filter(new RestAssuredRequestFilter())				
				.contentType(CONTENT_TYPE)
				.accept(CONTENT_TYPE);
	} 
}
