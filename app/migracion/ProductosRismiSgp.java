package migracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import play.Logger;

public class ProductosRismiSgp {
	
	public int getArticulo(int id){
		int r = 1537;
		Connection conn = null;
		try {
			conn = play.db.DB.getConnection();
			PreparedStatement stmt0 = conn.prepareStatement("select id from articulos where id = ?");
			stmt0.setInt(1, id);
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				r = rs0.getInt(1);
			}
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
            
        }
		return r;
	}
	
	public int getTipo(int id){
		int r = 2;
		Connection conn = null;
		try {
			conn = play.db.DB.getConnection();
			PreparedStatement stmt0 = conn.prepareStatement("select id from tipo_productos where id = ?");
			stmt0.setInt(1, id);
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				r = rs0.getInt(1);
			}
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
            
        }
		return r;
	}
	
	public int getCategorias(int id){
		int r = 14;
		Connection conn = null;
		try {
			conn = play.db.DB.getConnection();
			PreparedStatement stmt0 = conn.prepareStatement("select id from categorias where id = ?");
			stmt0.setInt(1, id);
			ResultSet rs0 = stmt0.executeQuery();
			while (rs0.next()) {
				r = rs0.getInt(1);
			}
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn != null) conn.close(); } catch (Exception e2) { }
            
        }
		return r;
	}
	
	public boolean xxx(){
		Connection conn = null;
		Connection conn2 = null;
		System.out.println("Empezo a ActualizarAutorizados");
		try {
			conn2 = play.db.DB.getConnection();
			PreparedStatement stmt0 = conn2.prepareStatement("select " +
															 "id_producto," +
															 "id_tipo_producto," +
															 "id_rubro," +
															 "id_articulo," +
															 "id_unidad_medida," +
															 "id_presentacion," +
															 "nombre," +
															 "descripcion," +
															 "estado, " +
															 "UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' ))  " +
															 "from stock_producto");
			
			ResultSet rs0 = stmt0.executeQuery();
			
			int pEncontrado = 0;
			int pNoEncontrado = 0;
			
			while (rs0.next()) {
		
				
				String nombreProducto = rs0.getString(10).toUpperCase().trim().replace(" ","").replace("-","").replace(".","");
				
				PreparedStatement stmt1 = conn2.prepareStatement("select id from productos " +
																 "where UPPER(replace(replace(replace(trim(nombre),' ','' ),'-',''),'.','' )) = ? " +
																 "OR codigo_rismi = ? ");
				stmt1.setString(1, nombreProducto);
				stmt1.setString(2, rs0.getString(1));
				ResultSet rs1 = stmt1.executeQuery();
				boolean estado = (rs0.getString(9).compareToIgnoreCase("A") == 0)?true:false;
				
				boolean encontro = false;
				while(rs1.next()){
					
					pEncontrado ++;
					encontro = true;
					Integer idProducto = rs1.getInt(1);
					Logger.debug("-"+rs0.getString(7));
					
					PreparedStatement stmtu = conn2.prepareStatement("UPDATE productos " +
							"SET " +
							"codigo_rismi = ?, " +
							"nombre = ?, " +
							"tipo_producto_id = ?, " +
							"categoria_id = ?, " +
							"articulo_id = ?, " +
							"udm_id = ?, " +
							"activo = ? " +
							"WHERE id = ? ");
					
					stmtu.setInt(1, rs0.getInt(1));//id rismi
					stmtu.setString(2, rs0.getString(7));//nombre
					stmtu.setInt(3, getTipo(rs0.getInt(2)));//tipo_producto
					stmtu.setInt(4, getCategorias(rs0.getInt(3)));//categoria
					stmtu.setInt(5,getArticulo(rs0.getInt(4)));//articulo
					stmtu.setInt(6, 1);//stmtu.setInt(6, rs0.getInt(5));//udm
					stmtu.setBoolean(7, estado);//estado veeeeeeeeer
					stmtu.setInt(8, rs1.getInt(1));//idsgp
					stmtu.executeUpdate();
					
					
					PreparedStatement stmtx = conn2.prepareStatement("select id_producto,id_dominio from stock_producto_dominio where id_producto = ? ");
					stmtx.setInt(1, rs0.getInt(1));
					ResultSet rsx = stmtx.executeQuery();
					boolean ban1 = true;
					while(rsx.next()){
						
						if(ban1){
							PreparedStatement stmtd = conn2.prepareStatement("DELETE FROM productos_depositos WHERE producto_id = ?");
							stmtd.setInt(1, idProducto);
							stmtd.executeUpdate();
							
							ban1 = false;
						}
						
						int idDeposito = rsx.getInt(2);
						
						if(idDeposito == 3){
							idDeposito = 25;
						}else if(idDeposito == 6){
							idDeposito = 3;
						}else if(idDeposito == 15){
							idDeposito = 30;
						} 
																													    
						PreparedStatement stmti = conn2.prepareStatement("INSERT INTO productos_depositos(producto_id, deposito_id) VALUES (?, ?)");
						stmti.setInt(1, idProducto);
						stmti.setInt(2, idDeposito);
						stmti.executeUpdate();
					}
				}
				
				if(!encontro){
					PreparedStatement stmti2 = conn2.prepareStatement("INSERT INTO productos( "+
				            "codigo_rismi,nombre,tipo_producto_id,categoria_id,articulo_id,udm_id,activo, "+
				            "cuenta_ingreso_id, cuenta_gasto_id) "+
				    "VALUES (?, ?, ?,  "+
				            "?, ?, ?, ?,"+
				            "226,255)");
					
					stmti2.setInt(1, rs0.getInt(1));//id rismi
					stmti2.setString(2, rs0.getString(7));//nombre
					stmti2.setInt(3, getTipo(rs0.getInt(2)));//tipo_producto
					stmti2.setInt(4, getCategorias(rs0.getInt(3)));//categoria
					stmti2.setInt(5, getArticulo(rs0.getInt(4)));//articulo
					stmti2.setInt(6, 1);//stmti2.setInt(6, rs0.getInt(5));//udm
					stmti2.setBoolean(7, estado);//estado veeeeeeeeer
					stmti2.executeUpdate();
					pNoEncontrado ++;
				}
				
				
				
			}
			
			Logger.debug("ENCONTRADOS:"+pEncontrado);
			Logger.debug("NO ENCONTRADOS:"+pNoEncontrado);
			
			
			
			
			
		}catch (SQLException e) {
	        //log.error("Error ResUserMigracion ", e);
	    	play.Logger.error("errror", e);
	    }finally {
            
            try { if (conn2 != null) conn2.close(); } catch (Exception e2) { }
            
        }
		
		System.out.println("Termino a ActualizarAutorizados");
		
		return true;
	}	
}
