package com.zoosite.test;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

 import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Root resource (exposed at path)
 */
@Path("zoosite")
public class MyResource extends ResourceConfig {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("zoodata")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zoo> getZooData() {

		ZooDao ob = new ZooDao();
		return ob.getAll();
	}

	@POST
	@Path("addzoodata")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean createZoo(Zoo zoo) {
		ZooDao ob = null;
		Boolean val = false;
		try {
			ob = new ZooDao();
			val = ob.save(zoo);
		} catch (HibernateException e) {
			throw new HibernateException(e.getMessage());
		}
		return val;

	}

	@POST
	@Path("editzoodata")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateZoo(Zoo zoo) {

		ZooDao ob = new ZooDao();
		ob.update(zoo);

	}

	@POST
	@Path("deletezoodata")
	@Produces(MediaType.APPLICATION_JSON)
	public Zoo deleteZoo(Zoo z) {

		Session session = HibernateUtil.getInstance().openSession();
		Transaction txTransaction = session.beginTransaction();
		int id = z.getZoo_id();
		Zoo zoo = session.get(Zoo.class, id);
		zoo.setActivity(1);
		session.merge(zoo);
		txTransaction.commit();

		session.close();

		return zoo;
	}

	@GET
	@Path("userdata")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUserData() {

		UserDao users = new UserDao();
		return users.getAll();

	}

	@POST
	@Path("edituserdata")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUser(Users user) {
		UserDao ob = new UserDao();
		ob.update(user);

	}

	@POST
	@Path("deleteuserdata")
	@Produces(MediaType.APPLICATION_JSON)
	public Users deleteUser(Users user) {
		int id = user.getUser_id();
		UserDao ob = new UserDao();
		return ob.delete(id);

	}

	@POST
	@Path("user/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Users checkUser(Users user) {
		UserDao ob = new UserDao();
		return ob.validateUser(user);

	}

	@POST
	@Path("adduserdata")
	@Produces(MediaType.APPLICATION_JSON)
	public String registerUser(Users user) {
		UserDao ob = new UserDao();
		if (ob.save(user)) {
			return "User Registered Successfully";
		}
		return "Email already Exists";

	}

	@GET
	@Path("animals")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Animals> getAnimalData() {

		AnimalDao animals = new AnimalDao();
		return animals.getAll();

	}

	@POST
	@Path("animal/create")

	@Produces(MediaType.APPLICATION_JSON)
	public Boolean createAnimal(Animals animal) {
		try {
			AnimalDao ob = new AnimalDao();
			ob.save(animal);
		} catch (HibernateException exc) {
			throw new HibernateException("Can be Created");
		}
		return true;

	}

	@POST
	@Path("animal/update")

	@Produces(MediaType.APPLICATION_JSON)
	public Boolean updateAnimal(Animals animal) {
		try {
			AnimalDao ob = new AnimalDao();
			ob.update(animal);
		} catch (HibernateException exc) {
			throw new HibernateException("Can be updated");
		}
		return true;

	}

	@POST
	@Path("animal/delete")

	@Produces(MediaType.APPLICATION_JSON)
	public Boolean deleteAnimal(int id) {
		try {
			AnimalDao ob = new AnimalDao();
			ob.delete(id);
		} catch (HibernateException exc) {
			throw new HibernateException("Can't be deleted	");
		}
		return true;

	}

}
