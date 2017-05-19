import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.ford.core.MongoDBSingleton;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

@Path("/Welcome")
public class Welcome {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{param}")
	public Response welcome(@PathParam("param") String message) {
		String responseMessage = "Hello " + message;
		return Response.status(200).entity(responseMessage).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}/{age}")
	public Response getMessage(@PathParam("name") String name, @PathParam("age") String age) {
		String responseMessage = "Hello " + name + " Your age is" + age;
		return Response.status(200).entity(responseMessage).build();
	}

	private static final String FILE_PATH = "c:\\myfile.txt";

	@GET
	@Path("/txt")
	@Produces("text/plain")
	public Response getFile() {
		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"RestTest_file.txt\"");
		return response.build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Path("{name}/{by}/{likes}/{year}/{description}")
	@Path("{name}/{age}/{year}")
	public Response insert(@PathParam("name") String name, @PathParam("age") String age,@PathParam("year") String year
			/*@PathParam("likes") Long likes, @PathParam("year") String year, @PathParam("by") String by*/) {
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getTestdb();
		DBCollection coll = db.getCollection("Books");
		BasicDBObject doc = new BasicDBObject("Name", name).append("age", age).append("year", year);/*append("likes", likes)
				.append("year", year).append("by", by);*/
		coll.insert(doc);
		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
		return Response.status(200).entity(db.getName()).build();
	}
}
