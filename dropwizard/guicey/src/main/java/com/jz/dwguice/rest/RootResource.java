package com.jz.dwguice.rest;

import com.jz.dwguice.service.InvItem;
import com.jz.dwguice.service.InvRecord;
import com.jz.dwguice.service.SampleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource is managed by guice. Two sub resources: one with guice and other, managed by hk (and created for
 * each request).
 *
 * @author Vyacheslav Rusakov
 * @since 27.07.2017
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/root")
public class RootResource {

    @Inject
    private SampleService service;
    @Inject
    private GuiceSubResource subResource;

    @Path("{pathParamId}/guice-sub")
    public GuiceSubResource guiceSubResource() {
        service.setState("root1");
        // simply returning guice managed instance (singleton)
        return subResource;
    }

    @Path("{pathParamId}/hk-sub")
    public Class<HkSubResource> hkSubResource() {
        // use state to guarantee the same instance used in sub resource
        service.setState("root2");
        // sub resource will be instantiated by hk2
        return HkSubResource.class;
    }

    @GET
    @Path("/read")
    public List<InvItem> readInv() {
        return this.service.read();
    }

    @POST
    @Path("/insert")
    public void insertInv(InvRecord record) {
        this.service.insert(record.getName(), record.getDescription());
    }
}
