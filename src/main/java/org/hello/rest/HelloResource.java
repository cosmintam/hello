/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hello.rest;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.hello.service.HelloService;
import org.slf4j.Logger;

@Path("/say")
@RequestScoped
public class HelloResource {

	@Inject
	private Logger logger;

	@Inject
	private HelloService helloService;

	@GET
	@Path("/hello/{name}")
	public String sayHello(@PathParam("name") @NotNull String name) {
		logger.info("Saying hello to {}", name);
		return helloService.sayHelloTo(name);
	}

	@GET
	@Path("/date")
	public String sayDate() {
		logger.info("Saying date.");
		return new Date().toString();
	}

}
