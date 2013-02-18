package com.test;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


@Path(value = "/")
public class Test {
	public Test(){
		System.out.println("Test 被实例化");
	}
	
	@GET
	@Path(value = "/echo/{msg}")
	public String hello(@PathParam(value = "msg") String msg){
		System.out.println("msg = " +msg);
		return msg;
	}
	
	
	@GET
	@Path(value = "/test")
	public Response myTest(){
		MyObject mo = new MyObject();
		mo.setMessage("<h4>this is a test message : "+new Date().toGMTString() +"</h4>");
		System.out.println("创建MyObject,message = " +mo.getMessage());
		return Response.ok().entity(mo).build();
	}
}
