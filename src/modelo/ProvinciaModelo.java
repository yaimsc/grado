package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Provincia;

public class ProvinciaModelo extends Conector{

	public Provincia selectProvincia(int id){
		
		Provincia provincia = new Provincia(); 

		try {
			
			
			PreparedStatement pst = super.conexion.prepareStatement("select * from provincias where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
				provincia.setId(rs.getInt("id"));
				provincia.setNombre(rs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return provincia;
		
	}
}
