package modelo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DataBase {
	MongoClientURI uri;
	MongoClient client;
	MongoDatabase db;
	MongoCollection<Document> dbUsuarios;
	Document doc;
	MongoCursor<Document>elementos;
	
	public DataBase() {
		uri  = new MongoClientURI("mongodb://equipo03:pis03equipo@ds113935.mlab.com:13935/equipo03"); 
        client = new MongoClient(uri);
        db = client.getDatabase(uri.getDatabase());
        dbUsuarios = db.getCollection("usuarios");
	}
	
	public void create(Persona p) {
		doc=new Document("email",p.getEmail())
				.append("clave", p.getPassword())
				.append("username", p.getUsername())
				.append("nombre", p.getNombre())
				.append("apellidos", p.getApellidos())
				.append("direccion", p.getDireccion())
				.append("telefono", p.getTelefono())
				.append("foto", p.getFoto());
		dbUsuarios.insertOne(doc);
	}
	
	public boolean existeEmail(String email) {
		boolean existe = false;
		elementos = dbUsuarios.find().iterator();
		while(elementos.hasNext()) {
			doc=elementos.next();
			if(doc.get("email").toString().equalsIgnoreCase(email))existe=true;
		}
		return existe;
	}
	
	public boolean existeUsername(String username) {
		boolean existe = false;
		elementos = dbUsuarios.find().iterator();
		while(elementos.hasNext()) {
			doc=elementos.next();
			if(doc.get("username").toString().equalsIgnoreCase(username))existe=true;
		}
		return existe;
	}
}
