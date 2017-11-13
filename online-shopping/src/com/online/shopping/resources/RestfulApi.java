package com.online.shopping.resources;

import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import com.online.shopping.DAO.Dao.Retrieve;
import com.online.shopping.Model.ShopppingCart;
import com.online.shopping.Model.User;

@Path("/online")
public class RestfulApi {

	 Retrieve rev=new Retrieve();
	@GET
	@Path("/rest/signup")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
                  int tt=rev.addUser(user.getUsernname(),user.getPassword());
         if(tt==1)
		return Response.status(200).entity("Signed up successfully").build();
         else
         {
        	 return Response.status(404).entity("Already present").build();
         }

	}
	@GET
	@Path("/rest/user/cart")
	@Produces(MediaType.APPLICATION_JSON)
		public Response getCart(@HeaderParam("authorization") String userAgent) {

		String decoded = new String(DatatypeConverter.parseBase64Binary(userAgent));
		StringTokenizer token=new StringTokenizer(decoded,":");
		String username=token.nextToken();
		String password=token.nextToken();
			List<ShopppingCart> shop=rev.viewMyCart(username);
	         if(shop != null)
			return Response.status(200).entity(shop).build();
	         else
	         {
	        	 return Response.status(403).entity("Unauthorized").build();
	         }

		}
	
	 @POST
	 @Path("/rest/user/cart")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes("application/json")
	 public Response addCart(@HeaderParam("authorization") String userAgent,ShopppingCart shop)
	 {
		 String decoded = new String(DatatypeConverter.parseBase64Binary(userAgent));
			StringTokenizer token=new StringTokenizer(decoded,":");
			String username=token.nextToken();
			String password=token.nextToken();
			boolean gee=rev.addCart(shop,username);
			if(gee)
			{
				return Response.status(200).entity("Added Succesfully").build();
			}
			else
			{
				 return Response.status(403).entity("Unauthorized").build();
			}
	 }
	

}
