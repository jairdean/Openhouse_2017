package j2b.db.com.ec;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClsMetodos {
	public boolean ComprobarLoguin(String usuario, String clave){
		boolean t = false;
		ClsConexion obj = new ClsConexion();
		ResultSet rs=null;
		String sql;
		sql = "Select * from tb_usuario where usuario='"+usuario+"' and clave='"+clave+"';";
		//sql2="Select tb_usuarios.id_usuario,nombre,apellido,clave,correo,direccion,celular,perfil,tb_activos_usuarios.estado from tb_usuarios,tb_activos_usuarios where tb_usuarios.id_usuario='"+usuario+"' and tb_usuarios.clave='"+clave+"' and tb_usuarios.id_usuario=tb_activos_usuarios.id_fk_usuario and tb_activos_usuarios.estado=true"+" group by tb_usuarios.id_usuario,nombre,apellido,clave,correo,direccion,celular,perfil,tb_activos_usuarios.estado;";
		try {
			rs = obj.Consulta(sql);
			while(rs.next()){
				t=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(t);
		System.out.println(sql);
		
		try {
			rs.close();
			obj.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
